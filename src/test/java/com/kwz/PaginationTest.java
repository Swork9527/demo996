package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kwz.entity.Student;
import com.kwz.mapper.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author keweizhong
 * @Date 2020/8/18 22:30
 */
@SpringBootTest
public class PaginationTest {
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void selectPageTest() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.le(Student::getId,50);

        IPage<Student> page = new Page<>(3, 5,true);

        IPage<Student> iPage = studentMapper.selectPage(page, wrapper);
        System.out.println("每页显示条数:"+iPage.getSize());
        System.out.println("总条数:"+iPage.getTotal());
        System.out.println("总页数:"+iPage.getPages());
        List<Student> records = iPage.getRecords();
        records.forEach(System.out::println);

    }

    @Test
    public void selectMapsPageTest() {
        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.le(Student::getId,50).
                select(Student::getStudentName,Student::getAge);

        Page<Map<String,Object>> page = new Page<>(1, 2,false);

        Page<Map<String, Object>> mapPage = studentMapper.selectMapsPage(page, wrapper);
        mapPage.getRecords().forEach(System.out::println);

    }
}
