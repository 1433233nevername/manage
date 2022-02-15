package com.jacks.login.web.controller.api;

import com.jacks.login.pojo.Student;
import com.jacks.login.service.StudentService;
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
@RequestMapping("/api/student")
public class APIStudentController {

    @Resource
    private StudentService studentService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ListResult getStudentList() {
        List<Student> studentList = studentService.findAll();
        ListResult listResult = new ListResult();
        listResult.setRows(studentList);
        return listResult;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CommonResult add(@RequestBody Student student) {
        studentService.add(student.getId(), student.getName(),student.getNumber(),student.getAge(),student.getEntime());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public CommonResult delete(@RequestBody Student student) {
        studentService.delete(student.getId());
        return ResultUtil.ok(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public CommonResult update(@RequestBody Student student) {
        studentService.update(student);
        return ResultUtil.ok(null);
    }
}
