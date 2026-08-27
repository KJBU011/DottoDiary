package com.mbc.dotto.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.dotto.dao.UsersDao;
import com.mbc.dotto.dto.UsersDto;

@Service
@Transactional
public class UsersService {
	final UsersDao dao;
	
	UsersService(UsersDao dao){
		this.dao = dao;
	}
	
	// 회원가입
	public boolean addUsers(UsersDto dto) {
		int count = dao.addUsers(dto);
		return count > 0;
	}
	
	//ID 중복체크
	public boolean getUsers(String id) {
		//return dao.getUsers(id) == null;
		
		return dao.getUsers(id); 
		// boolean 이 null 일때 검사 하려고 해서 에러가 난다.
		// boolean 을 사용하려면 == null 을 지우기
	}
	
	//로그인
	public UsersDto login(UsersDto dto) {
		UsersDto login = dao.login(dto);
		return login;
	}
}
