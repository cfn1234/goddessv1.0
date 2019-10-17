package com.goddess.service.impl;

import com.goddess.entity.UserEntity;
import com.goddess.mapper.UserMapper;
import com.goddess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.goddess.service.impl
 *
 * @author caofengnian
 * @Date 2019-10-17
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserEntity findByUserName(String userName) {

        return userMapper.findByUserName(userName);
    }
}