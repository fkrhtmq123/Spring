package kr.co.ch07.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.ch07.dao.UserDAO;
import kr.co.ch07.vo.UserVO;

@Service
public class UserService {
	
	@Inject
	private UserDAO dao;
	
	public void insertUser(UserVO vo) {
		dao.insertUser(vo);
	}
	
	public void selectUser() {}
	
	public List<UserVO> selectUsers() {
		return dao.selectUsers();
	}
	
	public void updateUser() {}
	
	public void deleteUser(UserVO vo) {
		dao.deleteUser(vo);
	}

}
