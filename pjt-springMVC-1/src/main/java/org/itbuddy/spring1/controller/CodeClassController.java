package org.itbuddy.spring1.controller;

import org.itbuddy.spring1.domain.CodeClass;
import org.itbuddy.spring1.service.CodeClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/codeclass")
public class CodeClassController {
	
	@Autowired
	private CodeClassService codeClassService;
	
	
	@GetMapping(value = "/register")
	public void registerForm(Model model) throws Exception{
		CodeClass codeClass = new CodeClass();
		
		model.addAttribute(codeClass);
	}
	
	@PostMapping(value = "/register")
	public String register(CodeClass codeClass, RedirectAttributes rttr) throws Exception{
		codeClassService.register(codeClass);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/codeclass/list";
	}
	
	@GetMapping(value = "/list")
	public void list(Model model) throws Exception{
		model.addAttribute("list",codeClassService.list());
	}
	
	@GetMapping(value = "/read")
	public void read(String classCode, Model model) throws Exception{
		model.addAttribute(codeClassService.read(classCode));
	}
	
	@PostMapping(value = "/modify")
	public String modify(CodeClass codeClass, RedirectAttributes rttr) throws Exception{
		
		codeClassService.modify(codeClass);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codeclass/list";
	}
	
	@PostMapping(value = "/remove")
	public String remove(String classCode, RedirectAttributes rttr) throws Exception{
		
		codeClassService.remove(classCode);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/codeclass/list";
	}
	
	
	


}
