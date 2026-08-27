package com.mbc.dotto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.DiariesDto;

@Mapper
@Repository
public interface DiariesDao {
	
	List<DiariesDto> diaryList(int grNo);
}
