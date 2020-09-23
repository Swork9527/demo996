package com.kwz.mapper;

import com.kwz.entity.Student;
import org.apache.ibatis.annotations.Select;

/**
 * @Author keweizhong
 * @Date 2020/9/13 3:07
 */
public interface StudentDao {
    /**
     * 根据id查询学生信息
     * @param id 学生的id
     * @return 学生信息
     */
    @Select("select * from student where id=#{id}")
    public Student selectOneById(int id);
}
