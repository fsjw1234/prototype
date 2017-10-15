package com.cheer.asst.mapper;

import com.cheer.asst.model.CategroyCnt;
import com.cheer.asst.domain.AsstCategroyEntity;
import com.cheer.asst.domain.AsstCategroyEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;

@MyBatisDao
public interface AsstCategroyEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AsstCategroyEntity record);

    int insertSelective(AsstCategroyEntity record);

    List<AsstCategroyEntity> selectByExample(AsstCategroyEntityExample example);

    AsstCategroyEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AsstCategroyEntity record);

    int updateByPrimaryKey(AsstCategroyEntity record);
    
    CategroyCnt preparePreCnt(String categroyId);

}