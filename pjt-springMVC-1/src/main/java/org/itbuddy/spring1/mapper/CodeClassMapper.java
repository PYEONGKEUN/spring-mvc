package org.itbuddy.spring1.mapper;

import java.util.List;

import org.itbuddy.spring1.domain.CodeClass;

public interface CodeClassMapper{
	public void create(CodeClass codeClass) throws Exception;	
	public List<CodeClass> list() throws Exception;
	public CodeClass read(String classCode) throws Exception;
	public void update(CodeClass codeClass) throws Exception;
	
	public void delete(String classCode) throws Exception;
}
