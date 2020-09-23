package com.kwz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kwz.mapper.StudentMapper;
import com.kwz.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @KWZ on 2020/7/24 15:56
 */
@Service
public class StudentService {


    @Autowired
    private StudentMapper studentMapper;

    /**
     * 获取所有学生的信息。
     * @return 所有学生的信息。
     */
    public List<Student> getStudents() {
        List<Student> studentList = studentMapper.selectList(null);

        return studentList;
    }

    public Student selectOne(int id){
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Student::getId,id);
        Student student = studentMapper.selectOne(wrapper);
        return student;
    }

}
