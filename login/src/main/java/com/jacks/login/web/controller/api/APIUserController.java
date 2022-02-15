package com.jacks.login.web.controller.api;

import com.jacks.login.pojo.User;
import com.jacks.login.service.UserService;
import com.jacks.login.web.result.CommonResult;
import com.jacks.login.web.result.ListResult;
import com.jacks.login.web.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class APIUserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getUserList() {
        List<User> userList = userService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(userList);
        return listResult;
    }
}
