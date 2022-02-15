package com.jacks.login.web.controller;

import com.jacks.login.pojo.Lesson;
import com.jacks.login.pojo.Student;
import com.jacks.login.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Resource
    private LessonService lessonService;

    @RequestMapping(value = "/add")
    public String add() {
        return "lesson_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "lesson_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Lesson lesson = lessonService.getById(id);
        model.addAttribute("lesson", lesson);
        return "lesson_edit";
    }
}
