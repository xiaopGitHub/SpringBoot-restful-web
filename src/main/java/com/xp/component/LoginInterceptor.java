package com.xp.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author xp
 * @CreateTime 2019/02/08  19:12
 * @Function 登陆检查拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     *  目标方法执行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception{
        Object username =request.getSession().getAttribute("username");
        if(username == null){
            //未登录
            request.setAttribute("msg","请先登录" );
            request.getRequestDispatcher("/login.html").forward(request,response );
            return false;
        }else{
            //已登陆,放行请求
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }

}
