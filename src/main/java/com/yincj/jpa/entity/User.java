package com.yincj.jpa.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity

public class User {
    @Id//声明ID
    @GeneratedValue//自动生成
    private long id;

    private String name;
}
