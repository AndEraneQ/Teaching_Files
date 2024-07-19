package com.demo_bank_v1.interceptors;

import com.demo_bank_v1.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class AppInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("in pre handle interceptor method");

        // TODO: CHECK REQUEST URL:
        if(request.getRequestURI().startsWith("/app")){
            // Get Session
            HttpSession session = request.getSession();

            // TODO: Get Token Stored In Session
            String token = (String)session.getAttribute("token");
            System.out.println(token);

            // TODO: Get User Object Stored In session
            User user = (User)session.getAttribute("user");



            // TODO: validate Session Attributes / Objects:
            if(token == null || user==null){
                response.sendRedirect("/login");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("in post handle interceptor method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("in after handle interceptor method");
    }
}
