package com.kwz.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.kwz.entity.Student;
import com.kwz.entity.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.ResultSetType;

import java.util.List;

/**
 * @author keweizhong
 * @date 2020-09-21 13:07:50
 */
//开启二级缓存
@CacheNamespace(blocking = true)
public interface StudentMapper extends BaseMapper<Student> {

    @Options(flushCache = Options.FlushCachePolicy.TRUE, useCache = true)
    @Select("select * from student where id = #{id}")
    Student findById(int id);

    /**
     *分页查询
     * @param start 分页开始
     * @param end   每一页的条数
     * @return 把分页结果封装在List
     */
    @Select("select * from student limit #{start},#{end}")
    List<Student> selectLimit(int start, int end);

    @Select("select student_name,email from student where id = #{id}")
    StudentInfo getStudentInfoById(int id);

    @Select("select * from student ${ew.customSqlSegment}")
    Student getByIdCustomizeSql(@Param(Constants.WRAPPER) Wrapper wrapper);

}
