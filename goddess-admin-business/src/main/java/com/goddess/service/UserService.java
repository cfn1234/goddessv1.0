package com.goddess.service;

import com.goddess.entity.UserEntity;

/**
 * com.goddess.service
 *
 * @author caofengnian
 * @Date 2019-10-17
 */

public interface UserService {

    UserEntity findByUserName(String userName);
}