package org.itbuddy.spring1.controller;



import java.util.List;

import org.itbuddy.spring1.domain.CodeDetail;
import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.service.CodeDetailService;
import org.itbuddy.spring1.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/codedetail")
//관리자 권한을 가진 사용자만 접근이 가능하다.
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class CodeDetailController {

	@Autowired
	private CodeDetailService codeDetailService;
	
	@Autowired
	private CodeService codeService;
	
	@GetMapping(value="/register")
	private void registerForm(Model model) throws Exception{
		// TODO Auto-generated method stub
		CodeDetail codeDetail = new CodeDetail();
		model.addAttribute(codeDetail);
		
		List<CodeLabelValue> classCodeList= codeService.getCodeClassList();
		model.addAttribute("classCodeList",classCodeList);

	}
	@PostMapping(value="/register")
	public String register(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception {
		codeDetailService.register(codeDetail);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/codedetail/list";
		         
	}
	
	@GetMapping(value = "/list")
	public void list(Model model) throws Exception{
		model.addAttribute("list", codeDetailService.list());
	}
	@GetMapping(value = "read")
	public void read(CodeDetail codeDetail, Model model) throws Exception{
		model.addAttribute(codeDetailService.read(codeDetail));
		List<CodeLabelValue> classCodeList = codeService.getCodeClassList();
		model.addAttribute("classCodeList",classCodeList);
		
	}
	
	@GetMapping(value = "modify")
	public void modifyForm(CodeDetail codeDetail, Model model) throws Exception{
		
		model.addAttribute(codeDetailService.read(codeDetail));
		List<CodeLabelValue> classCodeList = codeService.getCodeClassList();
		model.addAttribute("classCodeList", classCodeList);
	}
	
	@PostMapping(value = "modify")
	public String modify(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception{
		codeDetailService.modify(codeDetail);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codedetail/list";		
	}
	@PostMapping(value = "remove")
	public String remove(CodeDetail codeDetail, RedirectAttributes rttr) throws Exception{
		codeDetailService.remove(codeDetail);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codedetail/list";
	}
	
	
}
