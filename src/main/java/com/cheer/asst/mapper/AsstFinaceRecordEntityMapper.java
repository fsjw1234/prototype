package com.cheer.asst.mapper;

import com.cheer.asst.domain.AsstFinaceRecordEntity;
import com.cheer.asst.domain.AsstFinaceRecordEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;


@MyBatisDao
public interface AsstFinaceRecordEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AsstFinaceRecordEntity record);

    int insertSelective(AsstFinaceRecordEntity record);

    List<AsstFinaceRecordEntity> selectByExample(AsstFinaceRecordEntityExample example);

    AsstFinaceRecordEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AsstFinaceRecordEntity record);

    int updateByPrimaryKey(AsstFinaceRecordEntity record);
}