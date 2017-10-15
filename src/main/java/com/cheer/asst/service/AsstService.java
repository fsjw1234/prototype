package com.cheer.asst.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.asst.domain.AsstEntity;
import com.cheer.asst.domain.AsstEntityExample;
import com.cheer.asst.mapper.AsstCategroyEntityMapper;
import com.cheer.asst.mapper.AsstEntityMapper;
import com.cheer.asst.model.AssetsForm;
import com.cheer.asst.model.CategroyCnt;
import com.cheer.asst.pagination.PaginationCallback;
import com.cheer.asst.pagination.PaginationUtil;
import com.cheer.asst.pagination.PagingOutput;

import net.frank.yangtes.commons.service.BaseService;

@Service
public class AsstService extends BaseService {
	@Autowired
	private AsstEntityMapper asstMapper;
	@Autowired
	private AsstCategroyEntityMapper asstCategroyMapper;
	public void viewMaintain() {
		 
	}
	
	public void userHistory() {
		logger.info("AsstService.userHistory() triggered!");
	}
	public PagingOutput<AsstEntity> list(AssetsForm form) {
		return PaginationUtil.processPaging(form, new PaginationCallback<AsstEntity>() {
			@Override
			public List<AsstEntity> doProcess() {
				AsstEntityExample example = new AsstEntityExample();
				example.createCriteria().andDelFlagEqualTo("0");
				return asstMapper.selectByExample(example);
			}
		});
	}
	@Transactional
	public void save(AsstEntity entity,String operator){
		Date current = new Date();
		CategroyCnt cntInfo = asstCategroyMapper.preparePreCnt(entity.getCategoryId());
		logger.debug("Varible [cntInfo] -> " + cntInfo);
		//K-PC-0000001
		String bnsId = "K-" + cntInfo.getBnsPre() + "-" +   StringUtils.leftPad(( (cntInfo.getCnt()+1) + ""), 7, "0");
		logger.debug("Varible [bnsId] -> " + bnsId);
		entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		entity.setBnsId(bnsId);
		entity.setCreateBy(operator);
		entity.setCreateDate(current);
		entity.setDelFlag("0");
		asstMapper.insert(entity);
	}

}
