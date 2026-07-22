package com.navira.contactus.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

//@Component
//@Order(1)
public class LoggingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest newReq = (HttpServletRequest) servletRequest;
        HttpServletResponse newRes = (HttpServletResponse) servletResponse;
        String reqId = UUID.randomUUID().toString();
        Long startTime = System.currentTimeMillis();

        System.out.print("Request URI: " + newReq.getRequestURI() +"\n");
        System.out.println("Status code:"+newRes.getStatus());
        newRes.setHeader("X-reqID",reqId);
        try{
            filterChain.doFilter(servletRequest, servletResponse);
        }finally {
            Long endTime = System.currentTimeMillis();
            long differenceTime  = endTime - startTime;
            System.out.println("Time taken: " + differenceTime + " (ms)");
        }
    }
}
