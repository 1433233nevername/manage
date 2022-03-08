package com.zb.manage.web.interceptor;

import com.zb.manage.web.util.CookieUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignInInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userName = CookieUtil.getCookie(request, "user-name");
        if (StringUtils.isEmpty(userName)) {
            if (request.getRequestURI().startsWith("/api")) {
                throw new IllegalArgumentException("会话已失效，请刷新页面重新登录");
            } else {
                response.sendRedirect("/sign_in");
            }
        }
        return true;
    }
}
