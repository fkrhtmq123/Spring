package kr.co.kmarket.admin.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDAO;
import kr.co.kmarket.admin.persistence.AdminProductsRepo;
import kr.co.kmarket.vo.ProductsVO;

@Service
public class AdminProductService {

	@Autowired
	private AdminProductDAO dao;
	@Autowired
	private AdminProductsRepo repo;
	
	public void insertProduct(ProductsVO vo) {
		repo.save(vo);
	}
	
	public ProductsVO selectProduct() {
		return dao.selectProduct();
	}
	
	public List<ProductsVO> selectProducts(int start) {
		return dao.selectProducts(start);
	}
	
	public List<ProductsVO> selectProductsBySearch(int start, String opt, String keyword) {
		return dao.selectProductsBySearch(start, opt, keyword);
	}
	
	public void updateProduct() {
		dao.updateProduct();
	}
	
	public void deleteProduct() {
		dao.deleteProduct();
	}
	
	// Limit start 계산
	public int getLimitStart(String pg) {
		if(pg == null) {
			return 0;
		} else {
			int page = Integer.parseInt(pg);
			return (page - 1) * 10;
		}
	}
	
	public int selectCountProduct() {
		return dao.selectCountProduct();
	}
	
	public int selectCountProductBySearch() {
		return dao.selectCountProductBySearch();
	}
	
	public int getPageEnd(int total) {
		int pageEnd = 0;
		
		if(total % 10 == 0) {
			pageEnd = total / 10;
		} else {
			pageEnd = total / 10 + 1;
		}
		
		return pageEnd;
	}
	
	// list count 계산
	public int getListCount(int total, int start) {
		return (total - start) + 1;
	}
	
	// CurrentPg 계산
	public int getCurrentPg(String pg) {
		
		int currentPg = 0;
		
		if(pg == null) {
			currentPg = 1;
		}else {
			currentPg = Integer.parseInt(pg);
		}
		
		return currentPg;
	}
	
	@Value("${upload.path}")
	private String uploadPath;
	
	public ProductsVO uploadThunmb(ProductsVO vo) {
		// 업로드 경로
		String path = new File(uploadPath).getAbsolutePath();
		
		// 리스트 생성
		MultipartFile[] files = {vo.getFile1(),vo.getFile2(),vo.getFile3(),vo.getFile4()};
		
		// 파일 반복문
		for(int i=0; i<4; i++) {
			
			MultipartFile file = files[i];
			
			if(!file.isEmpty()) {
				
				String name = file.getOriginalFilename();
				String ext = name.substring(name.lastIndexOf("."));
				
				String uName = UUID.randomUUID().toString()+ext;
				String fullPath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";
				
				try {
					Path root = Paths.get(fullPath);
					Files.createDirectories(root);
					
					file.transferTo(new File(fullPath+uName));
					
					if(i==0) vo.setThumb1(uName);
					if(i==1) vo.setThumb2(uName);
					if(i==2) vo.setThumb3(uName);
					if(i==3) vo.setDetail(uName);
				} catch(IllegalStateException e) {
					e.printStackTrace();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}

		return vo;
	}
	
}
