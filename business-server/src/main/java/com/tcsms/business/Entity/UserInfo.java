package com.tcsms.business.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_info")
public class UserInfo {
    private String username;
    private String name;
    private String workerId;
    private String phoneNumber;
    private String sex;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "workerId")
    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(username, userInfo.username) &&
                Objects.equals(name, userInfo.name) &&
                Objects.equals(workerId, userInfo.workerId) &&
                Objects.equals(phoneNumber, userInfo.phoneNumber) &&
                Objects.equals(sex, userInfo.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name, workerId, phoneNumber, sex);
    }

    @Override
    public String toString() {

        return "{" +
                "\"username\":" + "\"" + username + "\"" + "," +
                "\"name\":" + "\"" + name + "\"" + "," +
                "\"workerId\":" + "\"" + workerId + "\"" + "," +
                "\"phoneNumber\":" + "\"" + phoneNumber + "\"" + "," +
                "\"sex\":" + "\"" + sex + "\"" +
                "}";
    }
}
