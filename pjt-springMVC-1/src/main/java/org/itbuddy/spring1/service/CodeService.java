package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.CodeLabelValue;

public interface CodeService {
	public List<CodeLabelValue> getCodeClassList() throws Exception;
}
