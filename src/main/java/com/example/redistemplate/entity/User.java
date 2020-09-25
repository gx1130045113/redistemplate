package com.example.redistemplate.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description: TODO
 * @Author 有丶优秀的少年
 * @Date 2020/9/24
 * @Version V1.0
 **/
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
}
