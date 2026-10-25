package com.mbc.dotto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.dotto.dao.GrouphomeDao;
import com.mbc.dotto.dto.GrouphomeDto;

@Service
@Transactional

public class GrouphomeService {
	
	//싱글턴 
		final  GrouphomeDao dao;
		
		GrouphomeService(GrouphomeDao dao) {
			// TODO Auto-generated method stub
				this.dao = dao;
				
		}
	
		//그룹정보 가져오기 
		public List<GrouphomeDto> GetGroup(int grNo) {
			return dao.GetGroup(grNo);
		}
		

}
