package com.zb.manage.web.controller;

import com.zb.manage.dal.model.ExamDO;
import com.zb.manage.biz.service.ExamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/web/exam")
public class ExamController {

    @Resource
    private ExamService examService;

    @RequestMapping(value = "/list")
    public String list() {
        return "exam/exam_list";
    }

    @RequestMapping(value = "/add")
    public String add() {
        return "exam/exam_add";
    }

    @RequestMapping(value = "edit")
    public String edit(BigInteger id, Model model) {
        ExamDO exam = examService.getById(id);
        model.addAttribute("exam", exam);
        return "exam/exam_edit";
    }
}
