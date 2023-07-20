package com.itwillbs.persistence;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.itwillbs.domain.MaterialVO;



@Repository
public class MaterialDAOImpl implements MaterialDAO {
	
	
	// 로거 생성
	private static final Logger logger = LoggerFactory.getLogger(MaterialDAOImpl.class);
	
	
	// DB연결을 위한 xml 객체 주입
	@Inject
	private SqlSession sqlSession;
	
	
	// Mapper 식별 NAMESPACE
	private static final String NAMESPACE = "com.itwillbs.mappers.materialMapper";
	

	
	// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ메서드 정의ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 1. 자재 목록 조회
	@Override
	public List<MaterialVO> getMaterialList() throws Exception {
		logger.debug("########## getMaterialList_호출");
		return sqlSession.selectList(NAMESPACE+".getMaterialList");
	}
	
	
	// 2. 자재 정보 조회
	@Override
	public MaterialVO getMaterialInfo(String ma_id) throws Exception {
		logger.debug("########## getMaterialInfo_호출");
		return sqlSession.selectOne(NAMESPACE+".getMaterialInfo", ma_id);
	}
	
	
	// 3-1. 자재 품목코드 자동넘버링
	@Override
	public String getMaxNumber() throws Exception  {
		logger.debug("########## getMaxNumber_호출");
		return sqlSession.selectOne(NAMESPACE+".getMaxNumber");
	}

	// 3-2. 자재 등록
	@Override
	public void insertMaterial(MaterialVO vo) throws Exception {
		logger.debug("########## insertMaterial_호출");
		sqlSession.insert(NAMESPACE + ".insertMaterial", vo);
		logger.debug("########## 자재 등록 완료");
	}
	
	
	// 4. 자재 검색
	@Override
	public List<MaterialVO> getSearchList(MaterialVO vo) throws Exception {
		logger.debug("########## getSearchList_호출");
		return sqlSession.selectList(NAMESPACE+".searchMaterial", vo);
	}


	// 5. 자재 수정
	@Override
	public Integer modifyMaterial(MaterialVO mvo) throws Exception {
		logger.debug("########## modifyMaterial_호출");
		
		// DB에서 수정할 자재 정보 가져오기
		// DAO -> mapper 호출 -> SQL 실행
		Integer result = sqlSession.update(NAMESPACE + ".modifyMaterial", mvo);
		logger.debug("########## 업데이트 된 행의 수 : " + result);
		
		return result;
	}
	
	
	// 6. 자제 삭제
	@Override
	public Integer deleteMaterial(String ma_id) throws Exception {
		logger.debug("########## deleteMaterial_호출");
		
		// DB에서 자제 삭제 기능 가져오기 (사실상 업데이트)
		return sqlSession.update(NAMESPACE+".deleteMaterial", ma_id);
	}


	// 7. 사원이름 가져오기
	@Override
	public String getEmpName(String ma_id) throws Exception {
		logger.debug("########## getEmpName_호출");
		return sqlSession.selectOne(NAMESPACE+".getEmpName", ma_id);
	}





	
	

	
	
}
