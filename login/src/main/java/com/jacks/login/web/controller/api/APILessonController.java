package com.jacks.login.web.controller.api;

import com.jacks.login.pojo.Lesson;
import com.jacks.login.pojo.Student;
import com.jacks.login.service.LessonService;
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
@RequestMapping("/api/lesson")
public class APILessonController {

    @Resource
    private LessonService lessonService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getLessonList() {
        List<Lesson> lessonList = lessonService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(lessonList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Lesson lesson) {
        lessonService.add(lesson.getLename(), lesson.getLenumber(), lesson.getTeachid(), lesson.getLetime());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody Lesson lesson) {
        lessonService.delete(lesson.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody Lesson lesson) {
        lessonService.update(lesson);
        return ResultUtil.ok(null);
    }
}
