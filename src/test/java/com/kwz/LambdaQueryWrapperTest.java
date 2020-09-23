package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.kwz.entity.Student;
import com.kwz.mapper.StudentMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author keweizhong
 * @date 2020/9/19 23:23
 */
@SpringBootTest
public class LambdaQueryWrapperTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void lambdaQueryWrapperTest() {
        //LambdaQueryWrapper<Student> wrapper = Wrappers.lambdaQuery();

        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();

        wrapper.select(Student::getStudentName,
                Student::getCreateTime,
                Student::getId,
                Student::getAge).lt(Student::getId, 8);

        List<Student> students = studentMapper.selectList(wrapper);
        students.forEach(System.out::println);
        System.out.println("-----------");
        List<Map<String, Object>> maps = studentMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }
}
