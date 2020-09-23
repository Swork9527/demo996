package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kwz.entity.Student;
import com.kwz.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author keweizhong
 * @Date 2020/8/19 23:57
 */
@SpringBootTest
public class UpdateTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void UpdateTest() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(Student::getId, Student::getAge, Student::getStudentName)
                .eq(Student::getId, 10086);
        Student student = studentMapper.selectOne(wrapper);
        System.out.println(student);

        student.setAge(student.getAge() + 1);

        studentMapper.updateById(student);

        System.out.println(studentMapper.selectById(student.getId()));
    }

    @Test
    public void UpdateWrapperTest() {
        LambdaQueryWrapper<Student> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Student::getStudentName, "OolmTDAdDYrM");

        //更新前
        System.out.println(studentMapper.selectOne(queryWrapper));

        UpdateWrapper<Student> wrapper = new UpdateWrapper<>();
        wrapper.eq("student_name", "OolmTDAdDYrM").set("age", 99);

        studentMapper.update(null, wrapper);

        //更新后
        System.out.println(studentMapper.selectOne(queryWrapper));

    }

    @Test
    public void test() {

        Student student = studentMapper.selectById(123);
        System.out.println(student);

        LambdaUpdateWrapper<Student> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(Student::getId,123).set(Student::getAge,88);

        studentMapper.update(null,wrapper);

        System.out.println(studentMapper.selectById(123));


    }

}
