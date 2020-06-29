package com.qfedu.dcy.interceptor;

import com.qfedu.dcy.utils.Data;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyIntercepter implements HandlerInterceptor {

    //执行目标方法前,会进行拦截;如果返回false代表不执行目标方法,如果返回true,进入下一个拦截或者执行目标方法
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies) {
            if (cookie.getName().equals("user")){//存在cookie,就表示已经登录了
                return true;
            }
        }
        System.out.println(request.getServletPath());
        String path=request.getServletPath();
        if (path.endsWith("/")){
            return true;
        }
        //用户没有登录
        Data data =new Data();
        data.setCode(-1);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write( mapper.writeValueAsString(data));
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        //返回视图之前;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //返回视图后;
    }



}
