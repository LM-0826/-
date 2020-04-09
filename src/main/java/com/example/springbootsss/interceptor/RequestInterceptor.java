package com.example.springbootsss.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author: 李明
 * @create: 2020-04-07 17:33
 * @Description:
 */
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        Object username = httpSession.getAttribute("username");
        String path = request.getServletPath();
        if (path.startsWith("/")) {
            return true;
        }
        if (username == null) {
            // 没有登录,重定向到登录页
            System.out.println("未登录，请登录");
            response.sendRedirect(request.getContextPath() + "/login/toLogin");
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }
}
