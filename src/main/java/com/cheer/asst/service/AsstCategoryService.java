package com.cheer.asst.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cheer.asst.domain.AsstCategroyEntity;
import com.cheer.asst.domain.AsstCategroyEntityExample;
import com.cheer.asst.mapper.AsstCategroyEntityMapper;
import net.frank.yangtes.commons.service.BaseService;

@Service
public class AsstCategoryService extends BaseService {

	@Autowired
	private AsstCategroyEntityMapper asstCategoryMapper;

	@Transactional
	public void save(AsstCategroyEntity entity, AsstCategroyEntity parent, String operatorId) {
		if (parent != null) {
			entity.setParentId(parent.getId());
			entity.setParentIds(parent.getParentIds() + parent.getId() + ",");
		} else {
			entity.setParentId("0");
			entity.setParentIds("0,");
		}
		Date currrentDate = new Date();
		if (StringUtils.isEmpty(entity.getId())) {
			entity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
			entity.setCreateDate(currrentDate);
			entity.setCreateBy(operatorId);
			entity.setDelFlag("0");
			asstCategoryMapper.insert(entity);
		} else {
			entity.setUpdateDate(currrentDate);
			entity.setUpdateBy(operatorId);
			asstCategoryMapper.updateByPrimaryKey(entity);
		}
	}

	public AsstCategroyEntity get(String asstCategroyId) {
		return asstCategoryMapper.selectByPrimaryKey(asstCategroyId);
	}

	public List<AsstCategroyEntity> all() {
		AsstCategroyEntityExample example = new AsstCategroyEntityExample();
		return asstCategoryMapper.selectByExample(example);
	}

	public AsstCategroyEntity getDefaultParent() {
		AsstCategroyEntityExample example = new AsstCategroyEntityExample();
		example.createCriteria().andParentIdEqualTo("0");
		List<AsstCategroyEntity> rt = asstCategoryMapper.selectByExample(example);
		if (rt != null && !rt.isEmpty()) {
			return rt.get(0);
		} else {
			return null;
		}
	}
}
