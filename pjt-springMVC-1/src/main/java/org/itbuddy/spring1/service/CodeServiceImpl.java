package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.mapper.CodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {

	@Autowired
	CodeMapper mapper;
	
	@Override
	public List<CodeLabelValue> getCodeClassList() throws Exception {
		return mapper.getCodeClassList();
	}

	@Override
	public List<CodeLabelValue> getCodeList(String classCode) throws Exception {
		return mapper.getCodeList(classCode);
	}

}
