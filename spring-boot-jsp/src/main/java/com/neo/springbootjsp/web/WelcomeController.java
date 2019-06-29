package com.neo.springbootjsp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(Map<String,Object> model){
        model.put("time",new Date());
        model.put("message","hello world");
        return "welcome";
    }
    @GetMapping("/user")
    public String user(Map<String,Object> model, HttpServletRequest request){
        model.put("username", "蔡徐坤");
        model.put("salary", 666);
        request.getSession().setAttribute("count",8);
        return "user";
    }
}
