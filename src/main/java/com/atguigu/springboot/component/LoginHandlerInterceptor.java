package com.atguigu.springboot.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:ChengZhang
 * @date: 2020/3/28
 * @time: 0:05
 * 登陆检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从session中获取拦截到的用户信息
        Object loginUser = request.getSession().getAttribute("loginUser");
        //判断用户信息是否为空，如果为空，就返回登陆页面
        if (loginUser == null){
            request.setAttribute("msg","客官老爷，您别走后门儿啊，请先登陆，谢谢您内！");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else {
            //如果不为空则放行请求
            return true;

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
