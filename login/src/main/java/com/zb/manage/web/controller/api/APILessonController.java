package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.LessonDO;
import com.zb.manage.biz.service.LessonService;
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
@RequestMapping("/api/lesson")
public class APILessonController {

    @Resource
    private LessonService lessonService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getLessonList() {
        List<LessonDO> lessonList = lessonService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(lessonList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody LessonDO lesson) {
        lessonService.add(lesson.getId(), lesson.getLename(), lesson.getLenumber(), lesson.getTeachid(), lesson.getLetime());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody LessonDO lesson) {
        lessonService.delete(lesson.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody LessonDO lesson) {
        lessonService.update(lesson);
        return ResultUtil.ok(null);
    }
}
