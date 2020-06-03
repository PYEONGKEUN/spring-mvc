package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeDetail;

public interface CodeDetailService {

	public void register(CodeDetail codeDetail) throws Exception;
	public List<CodeDetail> list() throws Exception;
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	public void modify(CodeDetail codeDetail) throws Exception;
	public void remove(CodeDetail codeDetail) throws Exception;
}
