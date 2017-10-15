package com.cheer.asst.mapper;

import com.cheer.asst.domain.UserAsstEntity;
import com.cheer.asst.domain.UserAsstEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;


@MyBatisDao
public interface UserAsstEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserAsstEntity record);

    int insertSelective(UserAsstEntity record);

    List<UserAsstEntity> selectByExample(UserAsstEntityExample example);

    UserAsstEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserAsstEntity record);

    int updateByPrimaryKey(UserAsstEntity record);
}