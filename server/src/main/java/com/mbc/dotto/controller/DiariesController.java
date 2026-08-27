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

	@GetMapping("diaryList")
	public List<DiariesDto> diaryList(int grNo){
		System.out.println("DiariesController diaryList()" + new Date());
		return service.diaryList(grNo);
	}
}
