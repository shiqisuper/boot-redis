package com.guotian.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserEntity implements Serializable {
    private Long userId;
    private String userName;

}
