package org.tukorea.myweb.persistence;

import java.util.List;

import org.tukorea.myweb.domain.ReservationVO;

public interface ReservationDAO {

	public boolean add(ReservationVO vo) throws Exception;
	public List<ReservationVO> getReservationList() throws Exception;
	public ReservationVO read(int intId) throws Exception;
	public boolean delete(int intId) throws Exception;
	public boolean update(ReservationVO vo) throws Exception;
	public List<String> reserveSeat(String movieId) throws Exception;
}
