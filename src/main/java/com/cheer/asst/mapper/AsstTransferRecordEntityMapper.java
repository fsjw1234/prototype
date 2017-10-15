package com.cheer.asst.mapper;

import com.cheer.asst.domain.AsstTransferRecordEntity;
import com.cheer.asst.domain.AsstTransferRecordEntityExample;

import net.frank.yangtes.commons.persistence.annotation.MyBatisDao;

import java.util.List;


@MyBatisDao
public interface AsstTransferRecordEntityMapper {
    int deleteByPrimaryKey(String id);

    int insert(AsstTransferRecordEntity record);

    int insertSelective(AsstTransferRecordEntity record);

    List<AsstTransferRecordEntity> selectByExample(AsstTransferRecordEntityExample example);

    AsstTransferRecordEntity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AsstTransferRecordEntity record);

    int updateByPrimaryKey(AsstTransferRecordEntity record);
}