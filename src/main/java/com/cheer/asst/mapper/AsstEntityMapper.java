package com.cheer.asst.mapper;

import com.cheer.asst.domain.AsstEntity;
import com.cheer.asst.domain.AsstEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;


@MyBatisDao
public interface AsstEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AsstEntity record);

    int insertSelective(AsstEntity record);

    List<AsstEntity> selectByExample(AsstEntityExample example);

    AsstEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AsstEntity record);

    int updateByPrimaryKey(AsstEntity record);
}