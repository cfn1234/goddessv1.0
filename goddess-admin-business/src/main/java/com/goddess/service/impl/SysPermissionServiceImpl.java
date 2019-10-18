package com.goddess.service.impl;

import com.goddess.mapper.SysPermissionMapper;
import com.goddess.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.goddess.service.impl
 *
 * @author caofengnian
 * @Date 2019-10-18
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public List<String> selectPermissionByUserId(Integer userId) {

        return sysPermissionMapper.selectPermissionByUserId(userId);
    }
}