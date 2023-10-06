package org.tukorea.myweb.domain;

import lombok.*;

@Getter
@Setter
@ToString
public class ReservationVO {

	private int reserveid;
	private String userid;
	private String movieid;
	private String moviename;
	private String seatnumber;

}
