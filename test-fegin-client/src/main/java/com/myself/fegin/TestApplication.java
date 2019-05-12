package com.myself.fegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/11
 * @author 【时间】22:51
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
