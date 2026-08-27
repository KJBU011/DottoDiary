package com.mbc.dotto.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mbc.dotto.dao.GrowingDao;
import com.mbc.dotto.dto.GrowingDto;

@Service
@Transactional //데이터 전송 중 에러 발생 시 초기화 
public class GrowingService {

	//싱글턴(컨트롤러와 연결됨 = Autowired를 사용한 것과 같음)
		final GrowingDao dao; //dao 를 돌려주겠다 
		
		GrowingService(GrowingDao dao){
			this.dao = dao;
		}
		
		//성장일지 댓글 작성
		public boolean GrowingContent(GrowingDto dto){
			return dao.GrowingContent(dto) > 0 ? true : false;
		}
							
}
