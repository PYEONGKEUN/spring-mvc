package org.itbuddy.spring1.mapper;

import java.util.List;

import org.itbuddy.spring1.domain.Board;
import org.itbuddy.spring1.domain.PageRequest;

public interface BoardMapper {

	public void create(Board board) throws Exception;
	public List<Board>list(PageRequest pageRequest) throws Exception;
	public Board read(int boardNo) throws Exception;
	public void update(Board board) throws Exception;
	public void delete(Integer boardNo) throws Exception;
	public int count() throws Exception;
	//검색 처리된리스트의 갯수를 반환
	public int count(PageRequest pageRequest) throws Exception;
	
	
}
