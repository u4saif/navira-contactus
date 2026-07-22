package com.navira.contactus.filter;

import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@Component
//@Order(2)
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        String token = req.getHeader("token");
        if(token==null || !token.equals("enu")){
           res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
