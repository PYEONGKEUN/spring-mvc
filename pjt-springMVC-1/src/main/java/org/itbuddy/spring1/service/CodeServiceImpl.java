package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.mapper.CodeClassMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeClassMapper mapper;
	
	@Override
	public List<CodeLabelValue> getCodeClassList() throws Exception {
		// TODO Auto-generated method stub
		mapper.get
	}

}
