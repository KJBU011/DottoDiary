package com.mbc.dotto.controller;


import java.util.Date; 
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.dotto.dto.GrowingDto;
import com.mbc.dotto.service.GrowingService;

@RestController
public class GrowingController {
	
	final GrowingService service; //Dao에서 싱글톤 final 설정했으면 컨트롤러에서도 받아주기 
	
	GrowingController(GrowingService service) {
		 this.service = service;
	}
		
	//성장일지 댓글 작성	
	@PostMapping("growingContent")
	public boolean GrowingContent(GrowingDto dto){
		System.out.println("GrowingController GrowingContent()" +  new Date()); //사용시 꼭 java utill로 추가하기 . 
		
		return service.GrowingContent(dto);
				
	}
}
