package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.Board;
import org.itbuddy.spring1.domain.PageRequest;

public interface BoardService {

	public void register(Board board) throws Exception;
	public List<Board> list(PageRequest pageRequest) throws Exception;
	public Board read(int boardNo) throws Exception;
	public void modify(Board board) throws Exception;
	public void remove(Integer boardNo) throws Exception;
	//검색 처리된리스트의 갯수를 반환
	public int count(PageRequest pageRequest) throws Exception;
}
