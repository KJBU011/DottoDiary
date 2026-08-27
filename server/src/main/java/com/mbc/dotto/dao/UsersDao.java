package com.mbc.dotto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.UsersDto;

@Mapper	 //다오를 만들어서 Users.xml이랑 연결하기 위해 맵퍼 설정을 해준다.
@Repository
public interface UsersDao {
	//회원가입
	int addUsers(UsersDto dto);
	
	//ID 중복체크
	//UsersDto getUsers(String id);
	
	boolean getUsers(String id);
	
	//로그인
	UsersDto login(UsersDto dto);
}
