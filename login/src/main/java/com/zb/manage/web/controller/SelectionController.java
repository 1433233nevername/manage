package com.zb.manage.web.controller;

import com.zb.manage.dal.model.Selection;
import com.zb.manage.biz.service.SelectionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigInteger;

@Controller
@RequestMapping("/selection")
public class SelectionController {

    @Resource
    private SelectionService selectionService;

    @RequestMapping("/add")
    public String add(){
        return "selection/selection_add";
    }

    @RequestMapping(value = "/list")
    public String list() {
        return "selection/selection_list";
    }

    @RequestMapping(value = "/edit")
    public String edit(@RequestParam BigInteger id, Model model) {
        Selection selection = selectionService.getById(id);
        model.addAttribute("selection", selection);
        return "selection/selection_edit";
    }
}
