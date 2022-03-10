package com.zb.manage.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class SystemController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/web/index";
    }

    @RequestMapping("/web/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/sign_in")
    public String signIn() {
        return "sign_in";
    }
}
