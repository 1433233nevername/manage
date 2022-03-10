package com.zb.manage.web.controller;

import com.zb.manage.dal.model.Student;
import com.zb.manage.biz.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/web/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/add")
    public String add() {
        return "student/student_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "student/student_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student/student_edit";
    }
}
