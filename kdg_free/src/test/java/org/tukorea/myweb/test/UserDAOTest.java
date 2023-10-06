package org.tukorea.myweb.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.myweb.domain.UserVO;
import org.tukorea.myweb.persistence.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserDAOTest {

	@Autowired
	private UserDAO dao;
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		UserVO vo;
		vo = dao.read("abc");

		logger.info(vo.toString());
	}
	@Test
	public void testReadList() throws Exception {
		List<UserVO> userList;
		userList = dao.getUserList();

		for(UserVO svo : userList) {
			logger.info(svo.toString());
		}
	}
	
}
