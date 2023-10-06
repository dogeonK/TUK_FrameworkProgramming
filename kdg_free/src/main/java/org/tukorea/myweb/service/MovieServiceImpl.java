package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.MovieVO;
import org.tukorea.myweb.persistence.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieDAO dao;

	public MovieVO readMovie(String strId) throws Exception {
		return dao.read(strId);
	}
	
	public List<MovieVO> getAllMovie() throws Exception {
		List<MovieVO> movieList = dao.getMovieList();
		return movieList;
	}

	public boolean addMovie(MovieVO vo) throws Exception {
		if (dao.add(vo))
			return true;
		else
			return false;
	}

	public boolean updateMovie(MovieVO vo) throws Exception {
		if (dao.update(vo))
			return true;
		else
			return false;
	}
	
	public boolean deleteMovie(String strId) throws Exception {
		if (dao.delete(strId))
			return true;
		else
			return false;
	}

}
