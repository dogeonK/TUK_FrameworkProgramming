package org.tukorea.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.tukorea.myweb.domain.MovieVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDAOImpl implements MovieDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.tukorea.myweb.mapper.MovieMapper";

	public MovieVO read(String id) throws Exception {
	
		MovieVO vo = sqlSession.selectOne(namespace+".selectByid", id);
		return vo;
	}
 
	public List<MovieVO> getMovieList() throws Exception {
		List<MovieVO> movieList = new ArrayList<MovieVO>();
		movieList = sqlSession.selectList(namespace + ".selectAll");
		return movieList;
	}
	
	public boolean add(MovieVO vo) throws Exception {
		sqlSession.insert(namespace + ".insert", vo);
		return true;
	}

	public boolean delete(String strId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".delete", strId);
		return true;
	}

	public boolean update(MovieVO vo) throws Exception {
		// TODO Auto-generated method stub
	    sqlSession.update(namespace + ".update", vo);
	    return true;
	}
	

}
