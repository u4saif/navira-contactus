package com.navira.contactus.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoggingInterceptor implements HandlerInterceptor {
    Long startTime;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest newReq = (HttpServletRequest) request;
        this.startTime = System.currentTimeMillis();

        System.out.println("Logging interceptor : " + newReq.getRequestURI());
        System.out.println("Status code:"+ ((HttpServletResponse) response).getStatus());
        System.out.println("Client IP: "+ newReq.getRemoteAddr());
        return true;

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpServletRequest newReq = request;
        Long endTime = System.currentTimeMillis();
        System.out.println("Request leaving Logging interceptor : " + newReq.getRequestURI());
        long timetaken = endTime - this.startTime;
        System.out.println("time taken in request "+ timetaken +" ms");
    }
}
