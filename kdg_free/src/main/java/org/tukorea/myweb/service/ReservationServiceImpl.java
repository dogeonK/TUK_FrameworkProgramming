package org.tukorea.myweb.service;

import java.util.List;

import org.tukorea.myweb.domain.ReservationVO;
import org.tukorea.myweb.persistence.ReservationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDAO dao;

	public List<ReservationVO> getAllReserve() throws Exception{
		List<ReservationVO> reservationList = dao.getReservationList();
		return reservationList;
	}

	public boolean deleteReserve(int intId) throws Exception {
		if (dao.delete(intId))
			return true;
		else
			return false;
	}

	public ReservationVO readReservation(int intId) throws Exception {
		return dao.read(intId);
	}

	public boolean addReservation(ReservationVO vo) throws Exception {
		if (dao.add(vo))
			return true;
		else
			return false;
	}

	public boolean updateReservation(ReservationVO vo) throws Exception {
		if (dao.update(vo))
			return true;
		else
			return false;
	}

	public boolean isReserve(String movieid, int i, char c) throws Exception {
		List<String> seatList = dao.reserveSeat(movieid);
		for (String seat : seatList){
			if(seat.equals(c+"-"+i)) {
				return true;
			}
		}
		return false;
	}
	

}
