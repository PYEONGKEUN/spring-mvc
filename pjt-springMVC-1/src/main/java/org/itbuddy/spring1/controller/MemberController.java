package org.itbuddy.spring1.controller;

import java.util.List;

import org.itbuddy.spring1.domain.CodeLabelValue;
import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.service.CodeService;
import org.itbuddy.spring1.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/user")
public class MemberController {

	@Autowired
	CodeService codeService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "/register")
	public void registerForm(Member member, Model model) throws Exception{
		String classCode = "A01";
		List<CodeLabelValue> jobList = codeService.getCodeList(classCode);
		model.addAttribute("jobList", jobList);		
	}
	
	@PostMapping(value = "/register")
	public String register(@Validated Member member, BindingResult result, Model model, RedirectAttributes rttr) throws Exception{
		if(result.hasErrors()) {
			   String classCode = "A01";
			   List<CodeLabelValue> jobList = codeService.getCodeList(classCode);
			   
			   model.addAttribute("jobList", jobList);
			   return "register";
		}
		String inputPassword = member.getUserPw();
		member.setUserPw(passwordEncoder.encode(inputPassword));
		
		memberService.register(member);
		
		//리다이렉트 할때 이전의 데이터가 소실 되는것을 막음
		// 리다이렉트시 이전 페이지의 데이터도 함께 전달
		rttr.addFlashAttribute("userName",member.getUserName());
		
		
		return "redirect:/registerSuccess";
	}
	
	@GetMapping(value = "/registerSuccess")
	public void register(Model model) throws Exception{

	}

	@GetMapping(value = "/list")
	public void list(Model model) throws Exception{
		model.addAttribute("list", memberService.list());
	}
	
	@GetMapping(value = "/read")
	public void read(int userNo, Model model) throws Exception{
		String classCode = "A01";
		List<CodeLabelValue> jobList = codeService.getCodeList(classCode);
		
		model.addAttribute("jobList", jobList);
		
		model.addAttribute(memberService.read(userNo));
	}
	
	@PostMapping(value = "/remove")
	public String remove(int userNo, RedirectAttributes rttr) throws Exception{
		memberService.remove(userNo);
		
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/user/list";
	}
	
	
	@GetMapping(value = "/modify")
	public void modifyForm(int userNo, Model model) throws Exception{
		String classCode = "A01";
		List<CodeLabelValue> jobList = codeService.getCodeList(classCode);
		
		model.addAttribute("jobList",jobList);
		
		model.addAttribute(memberService.read(userNo));
	}
	
	@PostMapping(value = "/modify")
	public String modify(Member member, RedirectAttributes rttr) throws Exception{
		memberService.modify(member);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/user/list";
	}	
	
	
	//ADMIN 권한을 가진 최초 관리자를 생성해야 한다.
	
	@GetMapping(value = "/setup")
	public String setupAdminForm(Member member, Model model) throws Exception{
		if(memberService.countAll() == 0) {
			return "user/setup";
		}
		return "user/setupFailure";
	}
	
	@PostMapping(value = "/setup")
	public String setupAdmin(Member member, RedirectAttributes rttr) throws Exception{
		if(memberService.countAll() == 0) {
			
			String inputPassword = member.getUserPw();
			member.setUserPw(passwordEncoder.encode(inputPassword));
			
			member.setJob("00");
			
			memberService.setupAdmin(member);
			rttr.addFlashAttribute("userName", member.getUserName());
			
			return "redirect:/user/registerSuccess";
		}
		return "redirect:/user/setupFailure";
		
	}
	

	
}
