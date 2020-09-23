package com.kwz.mapper;

import com.kwz.entity.Student;
import org.apache.ibatis.annotations.Select;

/**
 * Created by @KWZ on 2020/7/29 21:43
 */
public interface Hao {

    @Select("select * from student where id = #{id}")
    Student findById(int id);
}
