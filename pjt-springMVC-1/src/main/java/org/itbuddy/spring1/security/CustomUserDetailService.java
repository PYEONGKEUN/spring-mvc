package org.itbuddy.spring1.security;

import java.sql.SQLException;

import org.itbuddy.spring1.domain.CustomUser;
import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService{

	
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailService.class);
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		// userName은 사용자 아이디를 의미한다.
		
		logger.warn("Load User By UserName : " + userName);
		// 없으면 null 반환
		Member member = memberMapper.readByUserId(userName);
		
		logger.warn("queried by member mapper : " + member);
		
		return member == null ? null : new CustomUser(member);
		
		
	}

}    
