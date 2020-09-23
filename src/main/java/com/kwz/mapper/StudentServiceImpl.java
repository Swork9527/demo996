package com.kwz.mapper;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kwz.entity.Student;
import org.springframework.stereotype.Component;

/**
 * @Author keweizhong
 * @Date 2020/8/18 20:39
 */
@Component
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IService<Student> {
}
