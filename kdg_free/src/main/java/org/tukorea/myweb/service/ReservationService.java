package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.ReservationVO;

public interface ReservationService {
	
	public List<ReservationVO> getAllReserve() throws Exception;
	public boolean deleteReserve(int intId) throws Exception;
	public ReservationVO readReservation(int intId) throws Exception;
	public boolean addReservation(ReservationVO vo) throws Exception;
	public boolean updateReservation(ReservationVO vo) throws Exception;
	public boolean isReserve(String movieid, int i, char c) throws Exception;
	
}
