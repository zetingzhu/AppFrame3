package com.zzt.mylibrary2;

/**
 * @author: zeting
 * @date: 2021/1/4
 */
public class ActDemo {
    String title;
    String description;
    Class<?> activity;

    public ActDemo(String title, String description, Class<?> activity) {
        this.title = title;
        this.description = description;
        this.activity = activity;
    }
}
