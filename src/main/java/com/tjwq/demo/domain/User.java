package com.tjwq.demo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class User {

    private int id;

    @JsonProperty("userName")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @JsonIgnore
    private String email;

    private String age;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "zh", timezone = "GTM+8")
    private Date createTime;

    public User(String name, String email, String age, Date createTime) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.createTime = createTime;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
