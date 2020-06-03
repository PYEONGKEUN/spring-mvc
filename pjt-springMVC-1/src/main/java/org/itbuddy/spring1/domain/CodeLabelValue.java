package org.itbuddy.spring1.domain;

import java.io.Serializable;

public class CodeLabelValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8614614490220425263L;

	private String label;
	private String value;
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "CodeLabelValue [label=" + label + ", value=" + value + "]";
	}
	
	
}
