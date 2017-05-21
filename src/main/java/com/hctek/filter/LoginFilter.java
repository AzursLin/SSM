package com.hctek.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/5/21 0021.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
        HttpServletRequest ServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse ServletResponse = (HttpServletResponse) servletResponse;

        // 获得用户请求的URI
        String path = ServletRequest.getRequestURI();
        // 登陆页面无需过滤
        if(path.indexOf("/admin/Login") > -1) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
         }

        HttpSession session = ServletRequest.getSession();
        //将数据存储到session中
//                 session.setAttribute("data", "123");
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if ((session.getAttribute("myflag") != null) && (session.getAttribute("myflag").equals("sucess")))  {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            ServletResponse.sendRedirect("/admin/Login");
        }


    }

    @Override
    public void destroy() {

    }
}
