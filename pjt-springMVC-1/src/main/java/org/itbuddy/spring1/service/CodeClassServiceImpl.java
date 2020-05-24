package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeClass;
import org.itbuddy.spring1.mapper.CodeClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CodeClassServiceImpl implements CodeClassService {

	@Autowired
	private CodeClassMapper mapper;

	@Override
	public void register(CodeClass codeClass) throws Exception {
		mapper.create(codeClass);		
	}

	@Override
	public List<CodeClass> list() throws Exception {
		
		return mapper.list();
	}

	@Override
	public CodeClass read(String codeClass) throws Exception {

		return mapper.read(codeClass);
	}

	@Override
	public void modify(CodeClass codeClass) throws Exception {
		mapper.update(codeClass);
		
	}

	@Override
	public void remove(String classCode) throws Exception {

		mapper.delete(classCode);
	}
	
	
	
}
