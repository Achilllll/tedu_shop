package com.tedu.entity.model;

import com.tedu.utils.annotation.Column;

public class BaseEntity {
    private Class<?> c;
    @Column("id")
    private Integer id;

    public Class<?> getC() {
        return c;
    }

    public void setC(Class<?> c) {
        this.c = c;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
