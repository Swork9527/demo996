package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kwz.entity.Student;
import com.kwz.mapper.Hao;
import com.kwz.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.util.buf.CharChunk;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by @KWZ on 2020/7/22 13:55
 */
@SpringBootTest
public class BaseMapperTest {

    @Autowired
    StudentMapper studentMapper;


    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    Hao hao;


    @Test
    public void insert() {
        Student student = new Student();
        student.setStudentName("小明");
        student.setEmail("452@bb.com");
        student.setAge(24);
        student.setCreateTime(LocalDateTime.now());
        int i = studentMapper.insert(student);
        System.out.println(student.hashCode());
    }

    @Test
    public void selectBatchIds() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        //SELECT id,name,email,create_time FROM student WHERE id IN ( ? , ? , ? )
        List<Student> students = studentMapper.selectBatchIds(list);
        students.forEach(System.out::println);
    }

    @Test
    public void selectByMap() {
        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", "柯维忠");
        columnMap.put("id", 1);
        //SELECT id,name,email,create_time FROM student WHERE name = ? AND id = ?
        List<Student> studentList = studentMapper.selectByMap(columnMap);
        studentList.forEach(System.out::println);
    }

    /**
     * 查询指定的列
     */
    @Test
    public void test() {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.select("student_name","age").eq("id",1);
        System.out.println(studentMapper.selectOne(wrapper));
    }
}
