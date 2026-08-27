package com.mbc.dotto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.dotto.dao.DiariesDao;
import com.mbc.dotto.dto.DiariesDto;

@Service 
@Transactional
public class DiariesService {
	
	final DiariesDao dao;
	
	DiariesService(DiariesDao dao) {
		this.dao = dao;
	}
	
	public List<DiariesDto> diaryList(int grNo) {
		return dao.diaryList(grNo);
	}

}
