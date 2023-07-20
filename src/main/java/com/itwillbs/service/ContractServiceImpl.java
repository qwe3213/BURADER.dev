package com.itwillbs.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.ContractVO;
import com.itwillbs.domain.PagingVO;
import com.itwillbs.domain.ProductionVO;
import com.itwillbs.persistence.ContractDAO;

@Service
public class ContractServiceImpl implements ContractService {

	//로그출력을 위한 로거인스턴스 생성
	private static final Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);
	
	//DAO 사용을 위한 인스턴스 주입
	@Autowired
	private ContractDAO cdao;
	@Autowired
	private PagingService pageService;
	
	//페이징처리 변수저장을 위한 서비스 구현
	@Override
	public PagingVO setPageInfoForContract(PagingVO pvo) throws Exception {
		logger.debug("@@@@@@ContractService : 수주목록 페이징처리를 위한 변수 초기화 실행합니다.");
		
		//contract서비스에 필요한 변수를 저장. 
		pvo.setTable("contract");
		pvo.setId("cont_id");
		pvo.setPageSize(10);
		pvo.setStartRow(1);
		pvo.setStatus_name("cont_status");
		pvo.setStatus_value("0");
		logger.debug("@@@@@@ContractrService : {}",pvo);
		
		//페이지 계산을 위해서 pageingSerivce의 메소드 호출 
		pvo = pageService.pagingAction(pvo);
		logger.debug("@@@@@@ContractService : {}",pvo);
		return pvo;
	}
	
	//수주 상세보기
	@Override
	public ContractVO getContractInfo(String cont_id) throws Exception{
		logger.debug("@@@@@@ContractService : 수주 상세보기 실행합니다.");
		return cdao.readContractInfo(cont_id);
	}

	//수주 등록하기
	@Override
	public void registContract(ContractVO cvo) throws Exception{
		logger.debug("@@@@@@ContractService : 수주 등록하기 실행합니다.");
		
		
		///////////cont_id 조합하기 시작!///////////
		//먼저 디비 데이터의 가장 최신 자료를 불러온다. 
		String lastId = cdao.getLastGeneratedNumber();
		logger.debug("@@@@@@ContractService : getLastGeneratedNumber={}", lastId);
		
		String result = contIdCount();
		logger.debug("@@@@@@ContractService : contIdCount = {}", result);

		cvo.setCont_id(result);
		///////////cont_id 조합하기 끝!///////////

		cdao.insertContract(cvo);
	}
	
	//수주번호 자동계산하기 
	public String contIdCount() throws Exception{
		///////////cont_id 조합하기 시작!///////////
		//먼저 디비 데이터의 가장 최신 자료를 불러온다. 
		logger.debug("@@@@@@ContractService : 수주번호 자동계산을 호출합니다.");
		String lastId = cdao.getLastGeneratedNumber();
		logger.debug("@@@@@@ContractService : {}", lastId);
		
		//cont_id 접두사
		String prefix = "CO";
		
		// 현재 날짜를 계산한다. 
		LocalDate currentDate = LocalDate.now();
		String datePart = currentDate.toString().replace("-", "").substring(2, 8); // 년월일 6글자
	
		// 1부터 시작하는 카운트를 생성한다. 
		String countPart = String.format("%03d", 1);// 001부터 시작
		logger.debug("@@@@@@ContractService : countPart={}", countPart);

		String result = null;
		if(lastId == null) {
			//수주목록에 아무것도 없을 때
			logger.debug("@@@@@@ContractService : 수주목록이 없읍니다.");

			//접두사+현재날짜+001을 그냥 더한다.
			result = prefix + datePart + countPart;
			logger.debug("@@@@@@ContractService : result={}", result);

		}else {
			
			//수주목록이 있을 때 
			logger.debug("@@@@@@ContractService : 수주목록이 있읍니다..");

			//가운데 날짜 8자리를 추출한다. 
			String datePartUp = lastId.substring(2,8);
			logger.debug("@@@@@@ContractService : datePartUp={}", datePartUp);

			//디비와 오늘 날짜가 같을 경우 
			if(datePart.equals(datePartUp)) {
				//카운트 부분을 추려낸다. 
				Integer countPartUp = Integer.parseInt(lastId.substring(9,11));
				logger.debug("@@@@@@ContractService : countPartUp={}", countPartUp);

				//끝 3자리에 1을 더한다. 
				if(countPartUp >= 0) {
					countPartUp +=1;
					countPart = String.format("%03d", countPartUp);
					// 접두사+날짜+카운트를 조합한다.
					result = prefix + datePart + countPart;
					logger.debug("@@@@@@ContractService : result={}", result);
				}
			}else {
				//디비 날짜와 오늘 날짜가 다를 경우 그냥 더한다. 
				result = prefix + datePart + countPart;
			}
		}
		return result;
	} //contIdCount END

	//수주 수정하기
	@Override
	public Integer modifyContract(ContractVO cvo) throws Exception{
		logger.debug("@@@@@@ContractService : 수주 수정하기 실행합니다.");
		return cdao.updateContract(cvo);
	}

	//수주 삭제하기
	@Override
	public Integer removeContract(String cont_id) throws Exception{
		logger.debug("@@@@@@ContractService : 수주 삭제하기 실행합니다.");
		return cdao.deleteContract(cont_id);
	}
	
	//cont_id 를 out_product 테이블에 넣기 
	@Override
	public void contIdInsert(String cont_id) throws Exception {
		logger.debug("@@@@@@ContractService :수주번호를 출고테이블에 넣습니다.");
		cdao.contIdInsert(cont_id);
	}

	//product_id로 상품정보 불러오기
	@Override
	public ProductionVO getProductInfo(String product_id) throws Exception {
		logger.debug("@@@@@@ContractService : 상품코드로 상품정보를 불러옵니다.");
		return cdao.readProductInfo(product_id);
	}

	//엑셀화일 다운로드
	@Override
	public void downExcel(List<Object> contractList, HttpServletResponse response) throws IOException {
		logger.debug("@@@@@@ContractService : 상품코드로 상품정보를 불러옵니다.");
		logger.debug("@@@@@@ContractService : contractList : {}", contractList);
		logger.debug("@@@@@@ContractService : contractList.size() : {}", contractList.size());

		Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("첫번째 시트");
        int rowNum = 0;
        Cell cell = null;
        Row row = null;
        
        // 엑셀의 머리 
        int cellNum = 0;
        row = sheet.createRow(rowNum++);
        cell = row.createCell(cellNum++);
        cell.setCellValue("수주번호");
        cell = row.createCell(cellNum++);
        cell.setCellValue("상품코드");
        cell = row.createCell(cellNum++);
        cell.setCellValue("상품명");
        cell = row.createCell(cellNum++);
        cell.setCellValue("수주처");
        cell = row.createCell(cellNum++);
        cell.setCellValue("수주일");
        cell = row.createCell(cellNum++);
        cell.setCellValue("수주량");
        cell = row.createCell(cellNum++);
        cell.setCellValue("납기일");
        cell = row.createCell(cellNum++);
        cell.setCellValue("작업지시번호");
        cell = row.createCell(cellNum++);
        cell.setCellValue("담당자");
        logger.debug("contractList : {}",contractList);
        //엑셀 몸통
        for (int i = 0; i < contractList.size() ; i++) {
//    		logger.debug("반복문 시작합니다. ");
//        	contractList.get(0).get;

    		cellNum = 0;
            row = sheet.createRow(rowNum++);
            cell = row.createCell(cellNum++);
            cell.setCellValue(0);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
            cell = row.createCell(cellNum++);
            cell.setCellValue("학생" + i);
//    		logger.debug("@@@@@@ContractService : 한번 끝");

        }
 
        // Download
        response.setContentType("ms-vnd/excel");
        response.setHeader("Content-Disposition", "attachment;filename=student.xlsx");
        try {
            wb.write(response.getOutputStream());
        } finally {
            wb.close();
        }
    }

	
	//상품목록 가져오기
	@Override
	public List<ProductionVO> getProductList() throws Exception {
		return cdao.getProductList();
	}		
	
	
}
