package org.tukorea.myweb.controller;

import java.util.List;

import org.tukorea.myweb.domain.MovieVO;
import org.tukorea.myweb.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value="/movie")
public class MovieController {
	
	@Autowired
    private MovieService movieService;

	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	
	@RequestMapping(value = {"/join"}, method = RequestMethod.GET)
    public String addMovie() throws Exception {
		logger.info(" /movie/join");
        return "movie_add";
    }
	
	@GetMapping("/list")
    public String listMovie(Model model) throws Exception {
    	List<MovieVO> movieList = movieService.getAllMovie();
    	
		logger.info(" /movie/list");
        model.addAttribute("movieList", movieList);
        return "movie_list";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteMovie(@RequestParam("movieid") String movieid) throws Exception {
    	movieService.deleteMovie(movieid);
    	
		logger.info(" /movie/delete?movieid=?");
        return "redirect:/movie/list";
    }
    
	@RequestMapping(value = {"/update"}, method = RequestMethod.GET)
	public String updateMovie(@RequestParam("movieid") String movieid, Model model) throws Exception {
		MovieVO movie = movieService.readMovie(movieid);
		
		logger.info(" /movie/update?movieid=?");
		model.addAttribute("movie", movie);
		return "movie_update";
	}
	
    
//    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
	@PostMapping("/join")
	public String addMoviePOST( @ModelAttribute("movie") MovieVO movie) throws Exception {
		movieService.addMovie(movie);
		
		logger.info(" /join URL POST method called.");
		return "movie_result";
	}
	
	@PostMapping("/update")
	public String updateMoviePOST( @ModelAttribute("movie") MovieVO movie) throws Exception {
		movieService.updateMovie(movie);
		
		logger.info(" /update URL POST method called.");
		return "movie_result";
	}
}