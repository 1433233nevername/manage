package com.jacks.login.web.controller;

import com.jacks.login.mapper.TeacherMapper;
import com.jacks.login.pojo.Student;
import com.jacks.login.pojo.Teacher;
import com.jacks.login.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherMapper teacherMapper;

    @RequestMapping("/add")
    public String add(){
        return "teacher_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "teacher_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Teacher teacher = teacherMapper.getById(id);
        model.addAttribute("teacher", teacher);
        return "teacher_edit";
    }
}
