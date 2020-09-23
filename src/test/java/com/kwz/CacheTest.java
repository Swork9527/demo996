package com.kwz;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.kwz.entity.Student;

import com.kwz.mapper.Hao;
import com.kwz.mapper.StudentMapper;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Created by @KWZ on 2020/7/22 15:52
 */
@SpringBootTest
public class CacheTest {
    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    Hao hao;

    @Test
    public void secondLevelCacheTest() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        StudentMapper mapper1 = sqlSession1.getMapper(StudentMapper.class);
        Student user1 = mapper1.findById(1);

        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        StudentMapper mapper2 = sqlSession2.getMapper(StudentMapper.class);
        Student user2 = mapper2.findById(1);

        System.out.println(user1 == user2);
        sqlSession2.close();
    }

    @Test
    public void firstLevelCacheTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper Mapper = sqlSession.getMapper(StudentMapper.class);
        Student student1 = Mapper.selectById(1);
        Student student2 = Mapper.selectById(1);
        System.out.println(student1==student2);

        Student student3 = studentMapper.selectById(2);
        Student student4 = studentMapper.selectById(2);
        System.out.println(student3);

    }

}
