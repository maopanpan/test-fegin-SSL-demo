package com.myself.fegin.vo;

/**
 * @author 【name】毛攀攀
 * @author 【date】2019/05/08
 * @author 【时间】21:38
 * @author 【说明】
 * @author 【工程】test-spring-convert-demo
 * @author 【目录】com.myself.test.vo
 */
public class Person extends BaseRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
