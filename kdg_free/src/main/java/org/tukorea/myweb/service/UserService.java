package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.UserVO;

public interface UserService {
	
	public List<UserVO> getAllUser() throws Exception;
	public boolean deleteUser(String strId) throws Exception;
	public UserVO readUser(String strId) throws Exception;
	public boolean addUser(UserVO vo) throws Exception;
	public boolean updateUser(UserVO vo) throws Exception;
	public boolean loginUser(String strId, String strPwd) throws Exception;
	public boolean isAdmin(String strId) throws Exception;
}
