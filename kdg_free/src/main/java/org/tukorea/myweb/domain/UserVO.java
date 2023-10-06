package org.tukorea.myweb.domain;

import lombok.*;

@Data
public class UserVO {

	private String userid;
	private String passwd;
	private String username;
	private String anum;
	private String mobile;
	private String email;
	
	//0 = admin, 1 = common
	private int usertype;

}
