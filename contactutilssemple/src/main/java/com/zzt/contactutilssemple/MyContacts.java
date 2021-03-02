package com.zzt.contactutilssemple;

import java.util.List;

/**
 * @author: zeting
 * @date: 2020/12/8
 */
public class MyContacts {
    public String name;
    public List<String> phone;
    public List<String> group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }

    public List<String> getGroup() {
        return group;
    }

    public void setGroup(List<String> group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "MyContacts{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", group=" + group +
                '}';
    }
}
