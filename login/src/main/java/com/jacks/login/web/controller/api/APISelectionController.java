package com.jacks.login.web.controller.api;

import com.jacks.login.pojo.Selection;
import com.jacks.login.service.SelectionService;
import com.jacks.login.web.result.CommonResult;
import com.jacks.login.web.result.ListResult;
import com.jacks.login.web.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/selection")
public class APISelectionController {

    @Resource
    private SelectionService selectionService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getSelectList() {
        List<Selection> selectionList = selectionService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(selectionList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Selection selection) {
        selectionService.add(selection.getId(), selection.getStuid(), selection.getLesid(), selection.getTescore());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody Selection selection) {
        selectionService.update(selection);
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody Selection selection) {
        selectionService.delete(selection.getId());
        return ResultUtil.ok(null);
    }
}
