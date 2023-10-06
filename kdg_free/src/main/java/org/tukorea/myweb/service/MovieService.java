package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.MovieVO;

public interface MovieService {
	
	public MovieVO readMovie(String strId) throws Exception;
	public List<MovieVO> getAllMovie() throws Exception;
	public boolean addMovie(MovieVO vo) throws Exception;
	public boolean deleteMovie(String strId) throws Exception; 
	public boolean updateMovie(MovieVO vo) throws Exception;
	
}
