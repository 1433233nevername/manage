package com.zb.manage.web.controller.api;

import com.zb.manage.biz.vo.RecordVO;
import com.zb.manage.dal.model.Record;
import com.zb.manage.biz.service.RecordService;
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
@RequestMapping("/api/record")
public class APIRecordController {

    @Resource
    private RecordService recordService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getRecordList() {
        List<RecordVO> recordList = recordService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(recordList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Record record) {
        recordService.add(record.getId(), record.getExam_id(), record.getStudent_id(), record.getScore());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody Record record) {
        recordService.delete(record.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody Record record) {
        recordService.update(record);
        return ResultUtil.ok(null);
    }
}
