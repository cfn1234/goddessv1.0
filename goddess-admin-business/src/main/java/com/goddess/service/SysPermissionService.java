package com.goddess.service;

import java.util.List;

/**
 * com.goddess.service
 *
 * @author caofengnian
 * @Date 2019-10-18
 */
public interface SysPermissionService {

    List<String> selectPermissionByUserId(Integer userId);
}
