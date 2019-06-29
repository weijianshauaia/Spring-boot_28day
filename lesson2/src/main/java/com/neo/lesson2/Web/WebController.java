package com.neo.lesson2.Web;

import com.neo.lesson2.model.User;
import javafx.beans.binding.ObjectExpression;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//@RestController 注解相当于 @ResponseBody ＋ @Controller 合在一起的作用，
// 如果 Web 层的类上使用了 @RestController 注解，就代表这个类中所有的方法都会以 JSON 的形式返回结果，也相当于 JSON 的一种快捷使用方式；
//@RequestMapping(name="/getUser", method= RequestMethod.POST)，
// 以 /getUser 的方式去请求，method= RequestMethod.POST 是指只可以使用 Post 的方式去请求，如果使用 Get 的方式去请求的话，则会报 405 不允许访问的错误。
@RestController
public class WebController {
    @RequestMapping(name = "/getUser",method = RequestMethod.POST)
    public User getUser( ){
        User user = new User();
        user.setName("小明");
        user.setAge(12);
        user.setPass("123456");
        return user;

    }
    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=new ArrayList<User>();
        User user1=new User();
        user1.setName("neo");
        user1.setAge(30);
        user1.setPass("neo123");
        users.add(user1);
        User user2=new User();
        user2.setName("小明");
        user2.setAge(12);
        user2.setPass("123456");
        users.add(user2);
        return users;
    }
    @RequestMapping(value="get/{name}", method=RequestMethod.GET)
    public String get(@PathVariable String name) {
        return name;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid User user, BindingResult result){
        System.out.println("user:"+user);
        if(result.hasErrors()){
            List<ObjectError> list =result.getAllErrors();
            for(ObjectError error : list){
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
    }
    /*@Valid 参数前面添加 @Valid 注解，代表此对象使用了参数校验；
    BindingResult 参数校验的结果会存储在此对象中，
    可以根据属性判断是否校验通过，校验不通过可以将错误信息打印出来。*/

}
