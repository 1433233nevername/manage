package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.SelectionDO;
import com.zb.manage.biz.service.SelectionService;
import com.zb.manage.web.result.CommonResult;
import com.zb.manage.web.result.ListResult;
import com.zb.manage.web.util.ResultUtil;
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
        List<SelectionDO> selectionList = selectionService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(selectionList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody SelectionDO selection) {
        selectionService.add(selection.getId(), selection.getStuid(), selection.getLesid(), selection.getTescore());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody SelectionDO selection) {
        selectionService.update(selection);
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody SelectionDO selection) {
        selectionService.delete(selection.getId());
        return ResultUtil.ok(null);
    }
}
