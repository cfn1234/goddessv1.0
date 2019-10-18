package com.goddess.entity;

import java.io.Serializable;

/**
 * 用户
 * com.goddess.entity
 *
 * @author caofengnian
 * @Date 2019-10-17
 */
public class UserEntity implements Serializable {

    private static final long serialVersionUID = -5440372534300871944L;

    private Integer userId;

    private String userName;

    private String password;

    private String fullName;

    private String salt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}