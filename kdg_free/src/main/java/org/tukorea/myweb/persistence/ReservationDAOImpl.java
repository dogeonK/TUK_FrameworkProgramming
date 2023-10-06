package org.tukorea.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tukorea.myweb.domain.ReservationVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAOImpl implements ReservationDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.myweb.mapper.ReservationMapper";

	public ReservationVO read(int intId) throws Exception {
	
		ReservationVO vo = sqlSession.selectOne(namespace+".selectByid", intId);
		return vo;   
	}
 
	public List<ReservationVO> getReservationList() throws Exception {
		List<ReservationVO> reservationList = new ArrayList<ReservationVO>();
		reservationList = sqlSession.selectList(namespace + ".selectAll");
		return reservationList;
	}
	
	public boolean add(ReservationVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
		return true;
	}

	public boolean delete(int intId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", intId);
		return true;
	}

	public boolean update(ReservationVO vo) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", vo);
	    return true;
	}
	
	public List<String> reserveSeat(String movieid) throws Exception {
		List<String> seatList = new ArrayList<String>();
		seatList = sqlSession.selectList(namespace + ".reserveSeat");
		return seatList;
	}
	

}
