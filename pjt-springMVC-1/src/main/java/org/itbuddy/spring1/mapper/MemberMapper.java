package org.itbuddy.spring1.mapper;

import java.util.List;

import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.domain.MemberAuth;

public interface MemberMapper {
	public Member readByUserId(String userID) throws Exception;
	public void create(Member member) throws Exception;
	public Member read(int userNo) throws Exception;
	public void update(Member member) throws Exception;
	public void delete(int userNo) throws Exception;
	public List<Member> list() throws Exception;
	public void createAuth(MemberAuth memberAuth) throws Exception;
	public void deleteAuth(int userNo) throws Exception;
	
	public int countAll() throws Exception;
	
}
  