package com.zb.manage.web.controller;

import com.zb.manage.dal.model.Record;
import com.zb.manage.biz.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/record")
public class RecordController {

    @Resource
    private RecordService recordService;

    @RequestMapping(value = "/add")
    public String add() {
        return "record/record_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "record/record_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Record record = recordService.getById(id);
        model.addAttribute("record", record);
        return "record/record_edit";
    }
}
