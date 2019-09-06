package com.test.springbootlogin.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null){
            //未登录，返回登录页面
            request.setAttribute("msg","没有权限请先登录");
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }else {
            //已登录，放行请求
            return true;
        }
    }
}
