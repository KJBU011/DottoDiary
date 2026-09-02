package com.mbc.dotto.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.GrouphomeDto;
 


@Mapper
@Repository

public interface GrouphomeDao {
	
   //그룹정보 가져오기 (
	GrouphomeDto GetGroup(int grNo);

}