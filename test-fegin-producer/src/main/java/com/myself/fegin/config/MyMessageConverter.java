package com.myself.fegin.config;

import com.alibaba.fastjson.JSON;
import com.myself.fegin.vo.BaseRequest;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/12
 * @author 【时间】00:17
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.config
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<BaseRequest> {

    public MyMessageConverter() {
        super(new MediaType("application", "json", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        boolean v = BaseRequest.class.isAssignableFrom(clazz);
        return v;
    }

    @Override
    protected BaseRequest readInternal(Class<? extends BaseRequest> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(inputMessage.getBody(), Charset.forName("UTF-8"));
        return JSON.parseObject(temp, clazz);
    }

    @Override
    protected void writeInternal(BaseRequest baseRequest, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        outputMessage.getBody().write(JSON.toJSONString(baseRequest).getBytes());
    }
}
