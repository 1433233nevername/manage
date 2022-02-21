package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.User;
import com.zb.manage.biz.service.UserService;
import com.zb.manage.web.result.ListResult;
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
