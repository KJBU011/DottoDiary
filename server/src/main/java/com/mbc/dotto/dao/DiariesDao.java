package com.mbc.dotto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.DiariesDto;

@Mapper // sql 쿼리를 연결
@Repository // dao와 연결되는 db 저장소
public interface DiariesDao {

	List<DiariesDto> diaryList(int grNo);
	
}
