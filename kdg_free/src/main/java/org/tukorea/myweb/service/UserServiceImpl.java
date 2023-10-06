package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.UserVO;
import org.tukorea.myweb.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;

	public List<UserVO> getAllUser() throws Exception {
		List<UserVO> userList = dao.getUserList();
		return userList;
	}

	public boolean deleteUser(String strId) throws Exception {
		if (dao.delete(strId))
			return true;
		else
			return false;
	}

	public UserVO readUser(String strId) throws Exception {
		return dao.read(strId);
	}

	public boolean addUser(UserVO vo) throws Exception {
		if (dao.add(vo))
			return true;
		else
			return false;
	}

	@Transactional ( propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10 )
	public boolean updateUser(UserVO vo) throws Exception {
		if (dao.update(vo))
			return true;
		else
			return false;
	}

	public boolean loginUser(String strId, String strPwd) throws Exception {
		try {
			if (dao.read(strId).getPasswd().equals(strPwd)) {
				return true;
			}
			else return false;
		} catch (NullPointerException e) {
			return false;
		}
	}

	public boolean isAdmin(String strId) throws Exception {
		if (dao.read(strId).getUsertype() == 0) {
			return true;
		} else
			return false;
	}
}
