package com.kwz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;


import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 * @Author keweizhong
 * @Date 2020/8/16 0:19
 */
@Data
public class Student implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String studentName;

    private Integer age;

    private String email;

    private LocalDateTime createTime;

}
