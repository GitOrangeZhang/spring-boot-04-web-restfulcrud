package com.atguigu.springboot.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author:ChengZhang
 * @date: 2020/3/27
 * @time: 19:52
 */
public class MyLocaleResolver implements LocaleResolver {
    Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        //获取默认
        Locale locale = Locale.getDefault();
        //获取请求中的参数
        String l = request.getParameter("l");
        //获取中文和英文
        Locale zh_CN = Locale.SIMPLIFIED_CHINESE;
        Locale en_US = Locale.US;



        //如果请求中的参数不为空且等于中文，返回中文Locale，如果等于英文则返回英文Locale
        if (!StringUtils.isEmpty(l)){
            if ("zh_CN".equals(l)){
                return zh_CN;
            }else if ("en_US".equals(l)){
                return en_US;
            }else {
                return locale;
            }
        }else {
            return locale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
