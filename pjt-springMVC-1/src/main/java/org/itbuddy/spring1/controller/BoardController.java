package org.itbuddy.spring1.controller;

import java.util.ArrayList;
import java.util.List;

import org.itbuddy.spring1.domain.Board;
import org.itbuddy.spring1.domain.CodeLabelValue;
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
		
		// 페이지 네비게이션 정보에 검색처리된 게시글 건수를 저장한다.
		pagination.setTotalCount(boardService.count(pageRequest));
		
		model.addAttribute("pagination",pagination);
		
		//검색유형의 코드명과 코드값을 정의한다.
		List<CodeLabelValue> searchTypeValueList = new ArrayList<CodeLabelValue>();
		
		// 검색에 보여질 
		searchTypeValueList.add(new CodeLabelValue("n","---"));
		searchTypeValueList.add(new CodeLabelValue("t","Title"));
		searchTypeValueList.add(new CodeLabelValue("c","Content"));
		searchTypeValueList.add(new CodeLabelValue("w","Writer"));
		searchTypeValueList.add(new CodeLabelValue("tc","Title OR Content"));
		searchTypeValueList.add(new CodeLabelValue("cw","Content OR Writer"));
		searchTypeValueList.add(new CodeLabelValue("tcw","Title OR Content OR Writer"));
		
		model.addAttribute("searchTypeCodeValueList", searchTypeValueList);
	}
	
	@GetMapping("/read")
	public void read(int boardNo, @ModelAttribute("pgrq") PageRequest pageRequest, Model model) throws Exception {
		/*
		model.addAttribute(boardService.read(boardNo));
		*/
		
		Board board = boardService.read(boardNo);
		
		// 삭제
		/*
		board.setPageRequest(pageRequest);
		*/
		
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
	public String modify(Board board, PageRequest pageRequest, RedirectAttributes rttr) throws Exception{
		
		rttr.addAttribute("page",pageRequest.getPage());
		rttr.addAttribute("sizePerPage",pageRequest.getSizePerPage());
		rttr.addAttribute("searchType",pageRequest.getSearchType());
		rttr.addAttribute("keyword",pageRequest.getKeyword());
		
		rttr.addAttribute("msg","SUCCESS");
		
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
