package com.myself.fegin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/12
 * @author 【时间】00:18
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.config
 */
@Component
public class TestConfigurationAdapter implements WebMvcConfigurer {

    @Bean
    public MyMessageConverter myMessageConverter() {
        return new MyMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myMessageConverter());
    }
}
