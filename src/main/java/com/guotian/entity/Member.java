package com.guotian.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class Member implements Serializable {
    private Long id;

    private String name;

    private Integer age;
}
