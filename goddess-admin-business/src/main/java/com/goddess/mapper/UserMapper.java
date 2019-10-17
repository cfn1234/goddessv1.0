package com.goddess.mapper;

import com.goddess.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * com.goddess.mapper
 *
 * @author caofengnian
 * @Date 2019-10-17
 */
@Mapper
public interface UserMapper {

    UserEntity findByUserName(String userName);
}
