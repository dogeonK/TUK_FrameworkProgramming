package org.tukorea.myweb.controller;

import java.nio.charset.Charset;
import org.tukorea.myweb.domain.UserVO;
import org.tukorea.myweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/rest")
public class UserRestController {

	@Autowired(required=true)
    private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserVO> readMember(@PathVariable String id) throws Exception {
    	UserVO user = userService.readUser(id);
    	
		logger.info(" /user/rest/{id} REST-API GET method called.");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		headers.set("My-Header", "MyHeaderValue");
		return new ResponseEntity<UserVO>(user, headers, HttpStatus.OK);
    }
    
}
