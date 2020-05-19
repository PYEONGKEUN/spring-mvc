package org.itbuddy.spring1.service;

import java.util.List;

import org.itbuddy.spring1.domain.Member;
import org.itbuddy.spring1.domain.MemberAuth;
import org.itbuddy.spring1.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	
	@Autowired
	MemberMapper mapper;
	
	@Transactional
	@Override
	public void register(Member member) throws Exception {
		mapper.create(member);
		
		MemberAuth memberAuth = new MemberAuth();
		
		memberAuth.setUserNo(member.getUserNo());
		
		memberAuth.setAuth("ROLE_MEMBER");
		
		mapper.createAuth(memberAuth);
		
	}
	
	@Override
	public Member read(int userNo) throws Exception {
		return mapper.read(userNo);
	}
	
	@Transactional
	@Override
	public void modify(Member member) throws Exception {
		mapper.update(member);
		
		int userNo = member.getUserNo();
		
		mapper.deleteAuth(userNo);
		
		List<MemberAuth> authList = member.getAuthList();
		
		int authListSize = authList.size();
		for(int i = 0; i < authListSize; i++) {
			MemberAuth memberAuth = authList.get(i);
			
			String auth = memberAuth.getAuth();
			
			if(auth == null) {
				continue;
			}
			
			if(auth.trim().length() == 0) {
				continue;
			}
			
			memberAuth.setUserNo(userNo);
			
			mapper.createAuth(memberAuth);
		}
	}
	@Transactional
	@Override
	public void remove(int userNo) throws Exception {
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
		
	}
	@Override
	public List<Member> list() throws Exception {
		return mapper.list();
	}
	@Override
	public int getCoin(int userNo) throws Exception {
		Member member = mapper.read(userNo);
		
		return member.getCoin();
		
	}

}
