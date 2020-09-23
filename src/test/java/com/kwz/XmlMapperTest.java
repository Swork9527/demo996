package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kwz.entity.Student;
import com.kwz.entity.StudentInfo;
import com.kwz.mapper.StudentMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author keweizhong
 * @Date 2020/8/19 22:36
 */
@SpringBootTest
public class XmlMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void test() {
        StudentInfo studentInfo = studentMapper.getStudentInfoById(15);
        System.out.println(studentInfo);

        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<Student>()
                .eq(Student::getId, 15);

        System.out.println(studentMapper.getByIdCustomizeSql(wrapper));


    }

}
