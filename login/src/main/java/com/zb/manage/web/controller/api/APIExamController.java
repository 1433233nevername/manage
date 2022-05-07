package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.ExamDO;
import com.zb.manage.biz.service.ExamService;
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
@RequestMapping("/api/exam")
public class APIExamController {

    @Resource
    private ExamService examService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getExamList() {
        List<ExamDO> examList = examService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(examList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody ExamDO exam) {
        examService.add(exam.getId(), exam.getLessonid());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody ExamDO exam) {
        examService.delete(exam.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody ExamDO exam) {
        examService.update(exam);
        return ResultUtil.ok(null);
    }
}
