package com.cheer.asst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cheer.asst.domain.AsstEntity;
import com.cheer.asst.model.AssetsForm;
import com.cheer.asst.pagination.PagingOutput;
import com.cheer.asst.service.AsstService;

import net.frank.yangtes.commons.web.BaseController;
import net.frank.yangtes.modules.sys.utils.UserUtils;

@Controller
@RequestMapping(value="${adminPath}/asst")
public class AsstController extends BaseController{

	@Autowired
	private AsstService asstService;
	@RequestMapping(value = {"list",""})
	public String list(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		if(form == null){
			form = new AssetsForm();
		}
		PagingOutput<AsstEntity> output = asstService.list(form);
		form.setPageInfo(output.getPageInfo());
		form.setList(output.getList());
		model.addAttribute("form", form);
		return "modules/asst/list";
	}
	@RequestMapping(value="mine")
	public String mine() {
		return "modules/asst/mine";
	}
	
	@RequestMapping(value = "form")
	public String form(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		form.setEditor(new AsstEntity());
		form.getEditor().setStatus("P");
		model.addAttribute("form",form);
		return "modules/asst/form";
	}
	
	@RequestMapping(value = "save")
	public String save(@ModelAttribute AssetsForm form,Model model){
		logger.debug("Input Param [form] -> " + form );
		String operator = UserUtils.getUser().getId();
		asstService.save(form.getEditor(), operator);
		return list(form,model);
	}


}
