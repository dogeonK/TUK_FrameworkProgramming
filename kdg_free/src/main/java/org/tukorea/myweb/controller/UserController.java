package org.tukorea.myweb.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
    private UserService service;

	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	

	@GetMapping("/list")
    public String listMember(Model model) throws Exception {
    	List<UserVO> userList= service.getAllUser();
    	
		logger.info(" /user/list");
        model.addAttribute("userList", userList);
        return "user_list";
    }
	
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("userid") String userid) throws Exception {
    	service.deleteUser(userid);
    	logger.info("/user/delete");
    	return "redirect:/user/list";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(@RequestParam("userid") String userid, Model model) throws Exception {
    	UserVO user = service.readUser(userid);
    	
		logger.info(" /user/update?id=?");
        model.addAttribute("user", user);
        return "update";
    }
    
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinUser() throws Exception {
		logger.info(" /user/join");
		return "register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginUser() throws Exception {
		logger.info(" /user/login");
		return "login";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutUser(HttpSession session) throws Exception {
		logger.info(" /user/logout");
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/join")
	public String joinUserPost( @ModelAttribute("user") UserVO user) throws Exception {
		service.addUser(user);
		logger.info(" /user/join URL POST method called.");
		return "result";
	}

    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("user") UserVO user) throws Exception {
    	service.updateUser(user);
		logger.info(" /user/update URL POST method called.");
        return "redirect:/user/list";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUserPost(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
    	
    	logger.info(" /user/login?id=? URL POST method called.");
    	if(service.loginUser(request.getParameter("userid"), request.getParameter("passwd"))) {
			session.setAttribute("loginId", request.getParameter("userid"));
			if(service.isAdmin(request.getParameter("userid"))) {
				session.setAttribute("admin", true);
			}
			return "redirect:/";
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			 out.println("<script>alert('아이디 또는 비밀번호가 틀렸습니다.'); location.href='login';</script>");
			 return null;
		}
    	
    }
   
}