package com.atguigu.springboot.controller;

import com.atguigu.springboot.dao.EmployeeDao;
import com.atguigu.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author:ChengZhang
 * @date: 2020/3/29
 * @time: 21:44
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps",employees);
        return "emp/list";
    }
}
