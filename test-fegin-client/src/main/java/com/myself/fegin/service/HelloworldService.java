package com.myself.fegin.service;

import com.myself.fegin.vo.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/11
 * @author 【时间】22:52
 * @author 【说明】
 * @author 【工程】test-fegin-demo
 * @author 【目录】com.myself.fegin.service
 */
@FeignClient(name = "test-producer", url = "https://127.0.0.1:8080")
public interface HelloworldService {

    @GetMapping(value = "/sayHello")
    Person sayHello(@RequestBody Person person);
}
