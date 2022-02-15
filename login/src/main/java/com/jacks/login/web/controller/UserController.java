package com.jacks.login.web.controller;
import com.jacks.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.jacks.login.pojo.User;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(ModelMap model){
        return "user_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody User user) {
        userService.add(user.getUsername(), user.getPassword());
    }
}
