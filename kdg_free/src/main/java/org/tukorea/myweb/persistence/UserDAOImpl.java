package org.tukorea.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tukorea.myweb.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.myweb.mapper.UserMapper";

	public UserVO read(String strId) throws Exception {
	
		UserVO vo = sqlSession.selectOne(namespace+".selectByid", strId);
		return vo;   
	}
 
	public List<UserVO> getUserList() throws Exception {
		List<UserVO> userList = new ArrayList<UserVO>();
		userList = sqlSession.selectList(namespace + ".selectAll");
		return userList;
	}
	
	public boolean add(UserVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
		return true;
	}

	public boolean delete(String strId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", strId);
		return true;
	}

	public boolean update(UserVO vo) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", vo);
	    return true;
	}
	

}
