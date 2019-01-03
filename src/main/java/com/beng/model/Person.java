package com.beng.model;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    // 使用 @Value 赋值
    // 1. 基本数值
    // 2. spel #{}
    // 3. ${} 取配置文件
    @Value(value = "张三")
    private String username;
    @Value("#{20-2}")
    private int age;
    @Value("${nickname}")
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Person() {
    }

    public Person(String username, int age) {
        super();
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [username=" + username + ", age=" + age + ", nickname=" + nickname + "]";
    }

}
