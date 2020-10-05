package kr.co.farmstory.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDAO;
import kr.co.farmstory.vo.BoardVO;
import kr.co.farmstory.vo.FileVO;

@Service
public class BoardService {
	
	@Inject
	private BoardDAO dao;
	
	public void selectBoard() {}
	
	public List<BoardVO> selectBoards(int start, String cate) {
		return dao.selectBoards(start, cate);
	}
	
	public void insertBoard() {}
	
	public void updateBoard() {}
	
	public void deleteBoard() {}
	
	public List<BoardVO> selectLatest(String cate) {
		return dao.selectLatest(cate);
	}

	// Limit start ���
	public int getLimitStart(int currentPg) {
		return (currentPg-1)*10;
	}
	
	// ��ü �Խù� ����
	public int selectCountBoard(String cate) {
		return dao.selectCountBoard(cate);
	}
	
	// ������ ��ȣ ���
	public int getPageEnd(int total) {
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		} else {
			pageEnd = total / 10 + 1;
		}
		
		return pageEnd;
	}
	
	// list count ���
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	// CurrentPg ���
	public int getCurrentPg(String pg) {
		
		int currentPg = 0;
		
		if(pg == null) {
			currentPg = 1;
		}else {
			currentPg = Integer.parseInt(pg);
		}
		
		return currentPg;
	}
	
	// ���� ���ε�
	public FileVO fileUpload(HttpServletRequest req, int seq, MultipartFile file) {
		
		String path = req.getSession().getServletContext().getRealPath("/resources/files/");
		
		if(!file.isEmpty()) {
			// ���� ÷�� ������
			String oName = file.getOriginalFilename();
			String ext = oName.substring(oName.lastIndexOf("."));
			
			// �������ϸ� ����
			String uName = UUID.randomUUID().toString()+ext;
			
			// ���� ����
			try {
				file.transferTo(new File(path+uName));
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			FileVO vo = new FileVO();
			vo.setParent(seq);
			vo.setOldName(oName);
			vo.setNewName(uName);
			
			return vo;
			
		}else {
			// ���� ÷�� ��������
			return null;
		}
		
	}
	
	// ���� �ٿ�ε�
	public void fileDownload() {}
	
}
