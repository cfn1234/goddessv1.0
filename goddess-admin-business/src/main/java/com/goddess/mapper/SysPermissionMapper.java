package com.goddess.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
@Mapper
public interface SysPermissionMapper {

    List<String> selectPermissionByUserId(@Param("userId") Integer userId);
}
