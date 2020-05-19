package org.itbuddy.spring1.mapper;

import java.util.List;

import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.domain.MemberAuth;

public interface MemberMapper {
	Member readByUserId(String userID) throws Exception;
	void create(Member member) throws Exception;
	Member read(int userNo) throws Exception;
	void update(Member member) throws Exception;
	void delete(int userNo) throws Exception;
	List<Member> list() throws Exception;
	void createAuth(MemberAuth memberAuth) throws Exception;
	void deleteAuth(int userNo) throws Exception;
	
}
