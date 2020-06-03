package org.itbuddy.spring1.mapper;

import java.util.List;

import org.itbuddy.spring1.domain.CodeDetail;

public interface CodeDetailMapper {
	public void create(CodeDetail codeDetail) throws Exception;
	public Integer getMaxSortSeq(String classCode) throws Exception;
	public List<CodeDetail> list() throws Exception;
	public CodeDetail read(CodeDetail codeDetail) throws Exception;
	public void update(CodeDetail codeDetail) throws Exception;
	public void delete(CodeDetail codeDetail) throws Exception;
}
