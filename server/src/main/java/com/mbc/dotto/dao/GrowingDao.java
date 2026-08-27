package com.mbc.dotto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.GrowingDto;

@Mapper 
@Repository

public interface GrowingDao {
	
	//성장일지 댓글 작성
	int GrowingContent(GrowingDto dto);
	

}
