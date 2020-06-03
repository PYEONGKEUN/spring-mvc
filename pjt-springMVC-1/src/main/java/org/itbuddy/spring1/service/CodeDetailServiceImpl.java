package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeDetail;
import org.itbuddy.spring1.mapper.CodeDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeDetailServiceImpl implements CodeDetailService{

	
	@Autowired
	CodeDetailMapper mapper;
	
	@Override
	public void register(CodeDetail codeDetail) throws Exception {
		// TODO Auto-generated method stub
		String classCode = codeDetail.getClassCode();
		int maxSortSeq = mapper.getMaxSortSeq(classCode);
		
		codeDetail.setSortSeq(maxSortSeq + 1);		
		mapper.create(codeDetail);		
	}

	@Override
	public List<CodeDetail> list() throws Exception {
		return mapper.list();
	}

	@Override
	public CodeDetail read(CodeDetail codeDetail) throws Exception {
		return mapper.read(codeDetail);
	}

	@Override
	public void modify(CodeDetail codeDetail) throws Exception {
		mapper.update(codeDetail);
	}

	@Override
	public void remove(CodeDetail codeDetail) throws Exception {
		mapper.delete(codeDetail);
		
	}
	
	
	
	
}
