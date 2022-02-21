package com.zb.manage.web.controller;

import com.zb.manage.dal.model.Lesson;
import com.zb.manage.biz.service.LessonService;
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
        return "lesson/lesson_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "lesson/lesson_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Lesson lesson = lessonService.getById(id);
        model.addAttribute("lesson", lesson);
        return "lesson/lesson_edit";
    }
}
