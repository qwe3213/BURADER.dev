package com.itwillbs.persistence;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.itwillbs.domain.MaterialVO;



@Repository
public interface MaterialDAO {
	
	// 1. 자재 목록 조회
	public List<MaterialVO> getMaterialList() throws Exception;
	
	// 2. 자재 정보 조회
	public MaterialVO getMaterialInfo(String ma_id) throws Exception;
	
	// 3. 자재 검색
	public List<MaterialVO> getSearchList(MaterialVO vo) throws Exception;
	
	// 4-1. 자재 품목코드 자동넘버링
	public String getMaxNumber() throws Exception;
	
	// 4-2. 자재 등록
	public void insertMaterial(MaterialVO vo) throws Exception;
	
	// 5. 자재 수정
	public Integer modifyMaterial(MaterialVO mvo) throws Exception;
	
	// 6. 자재 삭제
	public Integer deleteMaterial(String ma_id) throws Exception;
	
	// 7. 사원이름 가져오기
	public String getEmpName(String ma_id) throws Exception;


}
