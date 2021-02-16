package com.wu.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(null == loginUser){
            request.setAttribute("msg", "No authority, please login first");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }

        return true;
    }
}
