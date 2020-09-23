package com.kwz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author keweizhong
 * @Date 2020/8/19 22:51
 */
@Data
public class StudentInfo implements Serializable {
    private String studentName;

    private String email;
}
