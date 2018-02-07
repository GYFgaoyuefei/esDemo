package com.run.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by quanyuan on 2018/2/7.
 */
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter开始工作");
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");
        //测试的
        System.out.println("dddddd");
    }
}
