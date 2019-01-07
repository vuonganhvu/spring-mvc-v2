package com.itss.spring.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class TestFilterServlet implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("bean filter " + this);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
