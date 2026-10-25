package com.mbc.dotto.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mbc.dotto.dto.GrouphomeDto;
 


@Mapper
@Repository

public interface GrouphomeDao {
	
   //그룹정보 가져오기 -> 그룹 인원 수대로 닉네임 다 가져와야 되니까 리스트로 가져오기 (dto 설계도 형식으로 만든)
	List<GrouphomeDto> GetGroup(int grNo);
	

}