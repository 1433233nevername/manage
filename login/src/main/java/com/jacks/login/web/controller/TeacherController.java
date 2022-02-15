package com.jacks.login.web.controller;

import com.jacks.login.mapper.TeacherMapper;
import com.jacks.login.pojo.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "teacher/teacher_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "teacher/teacher_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Teacher teacher = teacherMapper.getById(id);
        model.addAttribute("teacher", teacher);
        return "teacher/teacher_edit";
    }
}
