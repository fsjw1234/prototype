package com.cheer.asst.model;

import java.util.List;

import com.cheer.asst.domain.AsstEntity;
import com.cheer.asst.pagination.NoneConditionPagingInput;
import com.cheer.asst.pagination.SimplePageInfo;

public class AssetsForm extends NoneConditionPagingInput{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 928745635244719480L;

	private AsstEntity editor;
	
	private List<AsstEntity> list;
	
	public AssetsForm(){
		this.setPageInfo(new SimplePageInfo());
		this.getPageInfo().setCurrent(1);
		this.getPageInfo().setPageSize(2);
	}
	
	public AsstEntity getEditor() {
		return editor;
	}

	public void setEditor(AsstEntity editor) {
		this.editor = editor;
	}

	public List<AsstEntity> getList() {
		return list;
	}

	public void setList(List<AsstEntity> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "AssetsForm [super=" + super.toString() + ", editor=" + editor + ", list=" + list + "]";
	}
}
