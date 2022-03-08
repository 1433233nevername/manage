package com.zb.manage.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    private static final String DOMAIN = "dev-web.zb.com";

    public static final int COOKIE_TICKET_AGE = 60 * 60 * 8;

    public static final int COOKIE_GROUP_AGE = 60 * 60 * 24 * 365 * 10;

    public static String getCookie(HttpServletRequest request, String cookieName){
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(cookieName)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void writeCookie(HttpServletResponse response, String cookieName, String value, int age){
        Cookie cookie = new Cookie(cookieName,value);
        cookie.setPath("/");
        cookie.setMaxAge(age);
        cookie.setDomain(DOMAIN);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

    public static void deleteCookies(HttpServletResponse response, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            return;
        }
        for (Cookie oldCookie : cookies) {
            Cookie cookie = new Cookie(oldCookie.getName(), null);
            cookie.setMaxAge(0);
            cookie.setDomain(DOMAIN);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
    }
}
