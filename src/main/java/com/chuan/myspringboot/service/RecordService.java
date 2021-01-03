package com.chuan.myspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chuan.myspringboot.bean.ManageRcord;
import com.chuan.myspringboot.bean.ManageRcordExample;
import com.chuan.myspringboot.bean.ManageRcordExample.Criteria;
import com.chuan.myspringboot.dao.ManageRcordMapper;

@Service
public class RecordService {
	@Autowired
	ManageRcordMapper manageRcordMapper;
	public List<ManageRcord> get() {
		
		ManageRcordExample example = new ManageRcordExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdBetween(1, 200);
		return manageRcordMapper.selectByExample(example);
	}
}
