package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.Exam;
import com.zb.manage.dal.model.User;
import com.zb.manage.biz.service.UserService;
import com.zb.manage.web.result.CommonResult;
import com.zb.manage.web.result.ListResult;
import com.zb.manage.web.util.CookieUtil;
import com.zb.manage.web.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public CommonResult add(HttpServletResponse response, @RequestBody User user) {
        User userResult = userService.getByName(user.getUsername());
        if (null == userResult) {
            throw new IllegalArgumentException("账号不存在");
        }
        if (!user.getPassword().equals(userResult.getPassword())) {
            throw new IllegalArgumentException("密码不正确");
        }
        CookieUtil.writeCookie(response, "user-name", userResult.getUsername(), 60 * 60);
        return ResultUtil.ok(null);
    }

}
