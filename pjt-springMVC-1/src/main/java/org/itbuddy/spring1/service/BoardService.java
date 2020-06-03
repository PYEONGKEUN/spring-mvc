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
	public int count() throws Exception;
}
