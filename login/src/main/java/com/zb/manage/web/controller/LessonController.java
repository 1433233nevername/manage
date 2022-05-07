package com.zb.manage.web.controller;

import com.zb.manage.dal.model.LessonDO;
import com.zb.manage.biz.service.LessonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/web/lesson")
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
        LessonDO lesson = lessonService.getById(id);
        model.addAttribute("lesson", lesson);
        return "lesson/lesson_edit";
    }
}
