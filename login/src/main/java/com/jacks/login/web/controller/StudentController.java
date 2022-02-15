package com.jacks.login.web.controller;

import com.jacks.login.pojo.Student;
import com.jacks.login.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/add")
    public String add() {
        return "student_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "student_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Student student = studentService.getById(id);
        model.addAttribute("student", student);
        return "student_edit";
    }
}
