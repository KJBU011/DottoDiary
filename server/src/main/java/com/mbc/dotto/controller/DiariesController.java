package com.mbc.dotto.controller;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.dotto.dto.DiariesDto;
import com.mbc.dotto.service.DiariesService;

@RestController
public class DiariesController {
	
	final DiariesService service;
	
	DiariesController(DiariesService service) {
		this.service = service;
	}

// 어떤 정보를 가져올건지 생각하기
	// 일기 목록 & 일기 총 개수
	
	// 일기 목록
	// 어떤조건으로 올건지? 공통점: 그 사람이 속한 그룹 = 그 사람이 진입한 그룹들이고 해당한 내용들 
	// 일기(글)번호, 제목, 작성자, 작성날짜
	@GetMapping("diaryList")
	public List<DiariesDto> diaryList(int grNo){
//	접근지정자 리턴값의 자료형     함수명 (매개변수자료형 매개변수의 변수명)
		//  DiariesDto 가 Dto의 한줄이고 그것의 전체가 List 다
		System.out.println("DiariesController diaryList()" + new Date());
		List<DiariesDto>ab = service.diaryList(grNo);
		return ab;
	}
}
