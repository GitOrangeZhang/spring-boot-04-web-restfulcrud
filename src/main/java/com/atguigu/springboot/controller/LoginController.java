package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author:ChengZhang
 * @date: 2020/3/27
 * @time: 23:40
 */
@Controller
public class LoginController {

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String pwd, Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "zhangsan".equals(username)){
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            map.put("msg","登陆失败！");
            return "login";
        }
    }
}
