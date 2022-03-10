package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.Teacher;
import com.zb.manage.biz.service.TeacherService;
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
@RequestMapping("/api/teacher")
public class APITeacherController {

    @Resource
    private TeacherService teacherService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getStudentList() {
        List<Teacher> teacherList = teacherService.findAll();
        ListResult listResult1 = new ListResult();
        listResult1.setRows(teacherList);
        return listResult1;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Teacher teacher) {
        teacherService.add(teacher.getId(), teacher.getTeachid(), teacher.getTeachername());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody Teacher teacher) {
        teacherService.delete(teacher.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
        return ResultUtil.ok(null);
    }
}
