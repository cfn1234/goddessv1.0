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

    private Integer id;

    private String userName;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}