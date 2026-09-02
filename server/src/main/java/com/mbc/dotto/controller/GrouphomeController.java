package com.mbc.dotto.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbc.dotto.dto.GrouphomeDto;
import com.mbc.dotto.service.GrouphomeService;

@RestController //RestFul Api 방식이다
public class GrouphomeController {
	
	  final GrouphomeService service;
	  
	  GrouphomeController(GrouphomeService service) {
		this.service =service;
		
	}
	  
	  //그룹 정보 가져오기 
	  @PostMapping("groupHome")
	  public GrouphomeDto GetGroup(int grNo) {
		  
		  System.out.println("GrouphomeController GetGroup" +new Date());
		  
		  return service.GetGroup(grNo);
		 
	  }

}
