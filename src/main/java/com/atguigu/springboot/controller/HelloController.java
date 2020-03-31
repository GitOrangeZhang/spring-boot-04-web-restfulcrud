package com.atguigu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:ChengZhang
 * @date: 2020/3/23
 * @time: 23:32
 */

@Controller
public class HelloController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }


}
