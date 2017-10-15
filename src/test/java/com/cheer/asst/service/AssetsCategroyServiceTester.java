package com.cheer.asst.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cheer.asst.domain.AsstCategroyEntity;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({
		@ContextConfiguration(name = "parent", locations = "classpath:spring/spring-context.xml")
		})

public class AssetsCategroyServiceTester {
	
	protected transient Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AsstCategoryService service;
	
	@Test
	public void init(){
		
			AsstCategroyEntity item = new AsstCategroyEntity();
			item.setName("顶级品类");
			item.setBnsPre("ABS");
			service.save(item, null, "1");
		
			AsstCategroyEntity item0 = new AsstCategroyEntity();
			item0.setName("办公家俱");
			item0.setBnsPre("JG");
			service.save(item0, item, "1");
		
			AsstCategroyEntity item1 = new AsstCategroyEntity();
			item1.setName("桌");
			item1.setBnsPre("DK");
			service.save(item1, item0, "1");
		
			AsstCategroyEntity item2 = new AsstCategroyEntity();
			item2.setName("椅");
			item2.setBnsPre("CR");
			service.save(item2, item0, "1");
		
	}
	
	@Test
	public void testAll(){
		List<AsstCategroyEntity> all = service.all();
		log.info("Varible [all] -> " + all);
	}
}
