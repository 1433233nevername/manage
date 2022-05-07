package com.zb.manage.web.controller.api;

import com.zb.manage.dal.model.StudentDO;
import com.zb.manage.biz.service.StudentService;
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
@RequestMapping("/api/student")
public class APIStudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getStudentList() {
        List<StudentDO> studentList = studentService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(studentList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody StudentDO student) {
        studentService.add(student.getId(), student.getName(), student.getNumber(), student.getAge(), student.getEntime());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody StudentDO student) {
        studentService.delete(student.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody StudentDO student) {
        studentService.update(student);
        return ResultUtil.ok(null);
    }
}
