package org.tukorea.myweb.persistence;

import java.util.List;

import org.tukorea.myweb.domain.MovieVO;

public interface MovieDAO {

	public boolean add(MovieVO movie) throws Exception;
	public List<MovieVO> getMovieList() throws Exception;
	public boolean update(MovieVO vo) throws Exception;
	public MovieVO read(String strId) throws Exception;
	public boolean delete(String strId) throws Exception;

}
