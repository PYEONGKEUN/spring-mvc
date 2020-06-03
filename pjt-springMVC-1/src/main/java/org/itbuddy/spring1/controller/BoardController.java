package org.itbuddy.spring1.controller;

import org.itbuddy.spring1.domain.Board;
import org.itbuddy.spring1.domain.CustomUser;
import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.domain.PageRequest;
import org.itbuddy.spring1.domain.Pagination;
import org.itbuddy.spring1.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	
	@GetMapping("/register")
	//일반 사용자들만 접근가능
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String registerForm(Model model, Authentication authentication) throws Exception{
		//현재 로그인한 사용자 정보 가져오기
		CustomUser customUser = (CustomUser) authentication.getPrincipal();
		Member member = customUser.getMember();
		
		Board board = new Board();
		
		board.setWriter(member.getUserId());
		
		model.addAttribute(board);
		
		logger.info("registerForm");
		return "success";
	}
	@PostMapping("/register")
	//일반 사용자들만 접근가능
	@PreAuthorize("hasRole('ROLE_MEMBER')")
	public String read(Board board, RedirectAttributes rttr) throws Exception{
		
		boardService.register(board);
		rttr.addFlashAttribute("msg","SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/list")
	public void list(@ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception{
		model.addAttribute("list",boardService.list(pageRequest));
		
		Pagination pagination = new Pagination();
		pagination.setPageRequest(pageRequest);
		pagination.setTotalCount(boardService.count());
		
		model.addAttribute("pagination",pagination);
	}
	
	@GetMapping("/read")
	public void read(int boardNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		/*
		model.addAttribute(boardService.read(boardNo));
		*/
		
		Board board = boardService.read(boardNo);
		
		board.setPageRequest(pageRequest);
		
		model.addAttribute(board);
		
	}
	
	
	@GetMapping("/modify")
	//일반 사용자들만 접근가능
	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_MEMBER')")
	public void modifyForm(int boardNo, Model model) throws Exception{
		model.addAttribute(boardService.read(boardNo));
	}
	
	@PostMapping("/modify")
	//일반 사용자들만 접근가능
	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String modify(Board board, RedirectAttributes rttr) throws Exception{
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	//일반 사용자들만 접근가능
	@PreAuthorize("hasRole('ROLE_ADMIN','ROLE_MEMBER')")
	public String remove(int boardNo, RedirectAttributes rttr) throws Exception {
		boardService.remove(boardNo);
		rttr.addFlashAttribute("msg","SUCCESS");
		return "redirect:/board/list";
	}
	

	


}
