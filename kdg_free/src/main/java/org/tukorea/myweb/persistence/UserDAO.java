package org.tukorea.myweb.persistence;

import java.util.List;

import org.tukorea.myweb.domain.UserVO;

public interface UserDAO {

	public boolean add(UserVO vo) throws Exception;
	public List<UserVO> getUserList() throws Exception;
	public UserVO read(String strId) throws Exception;
	public boolean delete(String strId) throws Exception;
	public boolean update(UserVO vo) throws Exception;

}
