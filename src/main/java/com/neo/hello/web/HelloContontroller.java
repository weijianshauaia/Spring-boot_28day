package com.neo.hello.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*@RestController 的意思是 Controller 里面的方法都以 JSON 格式输出，不需要有其他额外的配置；
如果配置为 @Controller，代表输出内容到页面。
@RequestMapping("/hello") 提供路由信息，"
/hello" 路径的 HTTP Request 都会被映射到 hello() 方法上进行处理。*/
@RestController
public class HelloContontroller {
    @RequestMapping("hello")
    public String hello(String name){
        return "hello world ," + name;
    }
}
