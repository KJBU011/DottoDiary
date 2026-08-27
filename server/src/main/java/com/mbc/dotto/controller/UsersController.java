package com.mbc.dotto.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.dotto.dto.UsersDto;
import com.mbc.dotto.service.UsersService;

@RestController
public class UsersController {
	final UsersService service;
	
	UsersController(UsersService service){
		this.service = service;
	}
	
	//회원가입
	@PostMapping("addUsers")
	public boolean addUsers(UsersDto dto) {
		System.out.println("UsersController addUsers" + new Date());
		
		return service.addUsers(dto);
	}	
	
	//아이디 중복체크
	@PostMapping("getUsers")
	public boolean getUsers(String id) {
		System.out.println("UsersController getUsers" + new Date());
		
		return service.getUsers(id);
	}
	
	
	//로그인
	@PostMapping("login")
    public UsersDto login(UsersDto dto) {
        System.out.println("UsersController login " + new Date());
        return service.login(dto);
    }
}
