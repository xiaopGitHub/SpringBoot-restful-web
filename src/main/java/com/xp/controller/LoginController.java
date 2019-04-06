package com.xp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author xp
 * @CreateTime 2019/02/08  18:01
 * @Function 登陆控制器
 */
@Controller
public class LoginController {

    //接收Post请求
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("form-username") String username,
                        @RequestParam("form-password") String password,
                        Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username", username);
            //防止表单重复提交,可以重定向到页面,自定义的视图解析路径
            return "redirect:/success.html";
        }else{
//            map.put("msg","用户名或密码错误" );
            return "redirect:/login.html";
        }
    }
}
