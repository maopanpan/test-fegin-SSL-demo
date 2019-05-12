package com.myself.fegin.config;

import feign.Client;
import feign.RequestTemplate;
import feign.codec.Decoder;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.PageableSpringEncoder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Arrays;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/11
 * @author 【时间】23:04
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.config
 */
@Configuration
@EnableFeignClients(basePackages = "com.myself.fegin.service")
public class CertConfiguration {

    @Bean
    public Client feignClient() throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, IOException, CertificateException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        Resource resource = new ClassPathResource("keystore.p12");
        InputStream fis = resource.getInputStream();
        keyStore.load(fis, "123456".toCharArray());
        trustManagerFactory.init(keyStore);
        SSLContext ctx = SSLContext.getInstance("TLS");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:"
                    + Arrays.toString(trustManagers));
        }
        X509TrustManager trustManager = (X509TrustManager) trustManagers[0];

        ctx.init(null, new TrustManager[]{trustManager}, null);

        return new Client.Default(ctx.getSocketFactory(), (s, sslSession) -> true);
    }

    @Bean
    public Decoder feignDecoder() {
        return new ResponseEntityDecoder(new SpringDecoder(feignHttpMessageConverter()));
    }

    @Bean
    public Encoder feignEncoder() {
        return new SpringEncoder(feignHttpMessageConverter());
    }

    public ObjectFactory<HttpMessageConverters> feignHttpMessageConverter() {
        final HttpMessageConverters httpMessageConverters = new HttpMessageConverters(new MyMessageConverter());
        return new ObjectFactory<HttpMessageConverters>() {
            @Override
            public HttpMessageConverters getObject() throws BeansException {
                return httpMessageConverters;
            }
        };
    }
}
