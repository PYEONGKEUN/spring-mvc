package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.Board;
import org.itbuddy.spring1.domain.PageRequest;
import org.itbuddy.spring1.domain.Pagination;
import org.itbuddy.spring1.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;

	@Override
	public void register(Board board) throws Exception {
		mapper.create(board);		
	}
	
	@Override
	public List<Board> list(PageRequest pageRequest) throws Exception {
		return mapper.list(pageRequest);
	}
	
	@Override
	public Board read(int boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void modify(Board board) throws Exception {
		mapper.update(board);
		
	}

	@Override
	public void remove(Integer boardNo) throws Exception {
		mapper.delete(boardNo);		
	}

	//검색 처리된리스트의 갯수를 반환
	@Override
	public int count(PageRequest pageRequest) throws Exception {
		return mapper.count(pageRequest);
	}
	
	
}
