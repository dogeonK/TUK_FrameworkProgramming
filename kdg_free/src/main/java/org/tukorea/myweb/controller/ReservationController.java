package org.tukorea.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.tukorea.myweb.domain.*;
import org.tukorea.myweb.service.*;
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
public class ReservationController {
	
	@Autowired
    private ReservationService r_service;
	@Autowired
	private MovieService m_service;
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	
	@GetMapping("/reservation")
    public String reservation(@ModelAttribute("movieid") String movieid, Model model) throws Exception {
    	MovieVO movie = m_service.readMovie(movieid);
    	
		logger.info(" /reservation?movieid=?");
		model.addAttribute("movie", movie);
        return "reservation";
    }
    
    @RequestMapping(value = "/reservation/list", method = RequestMethod.GET)
    public String listMember(Model model) throws Exception {
    	List<ReservationVO> reservationList = r_service.getAllReserve();
    	
		logger.info(" /reservation/list");
        model.addAttribute("reservationList", reservationList);
        return "reservation_list";
    }
    
    @RequestMapping(value = "/reservation/delete", method = RequestMethod.GET)
    public String deleteReservation(@RequestParam("reserveid") int reserveid) throws Exception {
    	r_service.deleteReserve(reserveid);
    	logger.info("delete");
    	return "redirect:/reservation/list";
    }
    
	@PostMapping("/reservation")
	public String addReservationPost( @ModelAttribute("reservation") ReservationVO reservation) throws Exception {
		r_service.addReservation(reservation);
		
		logger.info(" /reservation URL POST method called.");
		return "reservation_result";
	}

   
}