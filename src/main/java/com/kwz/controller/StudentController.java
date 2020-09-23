package com.kwz.controller;

import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.kwz.entity.Student;
import com.kwz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author keweizhong
 * @date 2020/7/24 15:55
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Transactional(isolation = Isolation.REPEATABLE_READ, timeout = -1,rollbackFor = RuntimeException.class)
    @RequestMapping("/getStudents")
    @ResponseBody
    public List<Student> selectStudents() {
        List<Student> students = studentService.getStudents();
        return students;
    }


    @GetMapping("/student/{id}")
    @ResponseBody
    public Student selectOneStudent(@PathVariable("id") int id) {
        Student student = studentService.selectOne(id);
        System.out.println(student);
        return student;
    }

    @ResponseBody
    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student);
        return "OK";
    }

}
