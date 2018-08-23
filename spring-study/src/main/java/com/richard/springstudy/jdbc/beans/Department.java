package com.richard.springstudy.jdbc.beans;

/**
 * @program: myself_study
 * @description:
 * @author: Mr.Wang
 * @create: 2018-08-23 15:07
 **/
public class Department
{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
