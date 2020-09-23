package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fasterxml.jackson.datatype.jsr310.DecimalUtils;
import com.kwz.entity.Student;
import com.kwz.mapper.StudentMapper;
import org.apache.ibatis.javassist.expr.NewArray;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by @KWZ on 2020/7/22 19:32
 * QueryWrapper类：构造where查询条件
 */
@SpringBootTest
public class QueryWrapperTest {
    @Autowired
    StudentMapper studentMapper;

    /**
     * like查询
     */
    @Test
    public void like() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like("id", 250);
        /*
         * Preparing: SELECT id,name,age,email,create_time FROM student WHERE (name LIKE ?)
         * Parameters: %2%(String)
         */
        List<Student> students = studentMapper.selectList(wrapper);
        students.forEach(System.out::println);
    }

    /**
     * 条件嵌套
     */
    @Test
    public void likeRight() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        QueryWrapper<Student> wrapper1 = new QueryWrapper<>();
        /*  SELECT id,student_name,age,email,create_time
         *  FROM student
         *  WHERE (student_name LIKE "AKEJUsf%" AND (age < 26 AND email IS NOT NULL))
         */
        wrapper.likeRight("student_name", "AKEJUsf").and(wq -> wq.lt("age", 26).isNotNull("email"));
        wrapper1.nested(wq -> wq.lt("age", 26).isNotNull("email")).likeRight("student_name", "AKEJUsf");
        List<Student> studentList = studentMapper.selectList(wrapper);
        List<Student> studentList1 = studentMapper.selectList(wrapper1);
        System.out.println(studentList);
        System.out.println(studentList1);
    }

    /**
     * MySQL的in查询
     */
    @Test
    public void in() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.in("id", 1, 2);
        List<Student> students = studentMapper.selectList(wrapper);
        students.forEach(System.out::println);
    }

    /**
     * select()：选择要查询的字段
     * 选择排除的列
     */
    @Test
    public void select() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("id", "student_name").in("id", 10010, 10086);

        List<Student> students = studentMapper.selectList(wrapper);

        List<Map<String, Object>> maps = studentMapper.selectMaps(wrapper);

        students.forEach(System.out::println);
        maps.forEach(System.out::println);
    }

    /**
     * 排除不需要的列
     */
    @Test
    public void selectTest() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select(Student.class,info->!info.getColumn().equals("email")).eq("id",123);

        Student student = studentMapper.selectOne(wrapper);
        System.out.println(student);
    }

    @Test
    public void conditionTest() {
        Student student1 = new Student();
        student1.setId(1l);
        student1.setCreateTime(LocalDateTime.now());
        studentMapper.updateById(student1);

        String name = "5 ";
        System.out.println("isBlank:" + name.isBlank());
        System.out.println("isEmpty:" + name.isEmpty());

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isBlank(name), "name", "柯维忠");

        List<Student> student = studentMapper.selectList(wrapper);
        student.forEach(System.out::println);
    }

    @Test
    public void allEqTest() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("student_name", "AKEJUsfnHyKI");
        map.put("age", 22);
        wrapper.allEq(map);

        List<Student> students = studentMapper.selectList(wrapper);
        students.forEach(System.out::println);
    }

    @Test
    public void selectMapsTest() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("id", "student_name","email").gt("id", 200).lt("id", 350);

        List<Map<String, Object>> maps = studentMapper.selectMaps(wrapper);

        maps.forEach(System.out::println);

    }

    @Test
    public void selectCountTest() {
        Integer count = studentMapper.selectCount(null);
        System.out.println(count);

        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("*");
        Integer count1 = studentMapper.selectCount(wrapper);
        System.out.println(count1);

    }


}
