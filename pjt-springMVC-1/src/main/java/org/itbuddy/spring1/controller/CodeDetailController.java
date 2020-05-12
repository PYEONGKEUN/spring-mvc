package org.itbuddy.spring1.controller;



import java.util.List;

import org.itbuddy.spring1.domain.CodeDetail;
import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.service.CodeDetailService;
import org.itbuddy.spring1.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/codedetail")
public class CodeDetailController {

	@Autowired
	private CodeDetailService codeDetailService;
	
	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value="/register",method = RequestMethod.GET)
	private void registerForm(Model model) throws Exception{
		// TODO Auto-generated method stub
		CodeDetail codeDetail = new CodeDetail();
		model.addAttribute(codeDetail);
		
		

	}
	
}
