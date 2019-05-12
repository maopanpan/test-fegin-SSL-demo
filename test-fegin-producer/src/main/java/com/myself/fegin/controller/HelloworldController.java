package com.myself.fegin.controller;

import com.myself.fegin.vo.Person;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/11
 * @author 【时间】22:45
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.controller
 */
@RestController
public class HelloworldController {

    @RequestMapping(value = "/sayHello", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Person sayHello(@RequestBody Person person) {
        return person;
    }
}
