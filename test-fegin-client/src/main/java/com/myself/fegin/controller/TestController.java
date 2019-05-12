package com.myself.fegin.controller;

import com.alibaba.fastjson.JSON;
import com.myself.fegin.service.HelloworldService;
import com.myself.fegin.vo.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/11
 * @author 【时间】22:55
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.controller
 */
@RestController
public class TestController {

    private final HelloworldService helloworldService;

    public TestController(HelloworldService helloworldService) {
        this.helloworldService = helloworldService;
    }

    @GetMapping(value = "/sayHello")
    public String sayHello(@RequestBody Person person) {
        Person person1 = helloworldService.sayHello(person);
        return JSON.toJSONString(person1);
    }
}
