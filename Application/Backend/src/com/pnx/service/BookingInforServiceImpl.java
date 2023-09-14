package com.pnx.services;

import java.util.List;

import com.pnx.dao.BookingInfoDao;
import com.pnx.models.BookingInformation;

public class BookingInforServiceImpl implements BookingInfoService {
   private BookingInfoDao dao;
  
	public void setDao(BookingInfoDao dao) {
	this.dao = dao;
}

	@Override
	public BookingInformation findBooking(int bookingId) {
		// TODO Auto-generated method stub
		return dao.readBooking(bookingId);
	}

	@Override
	public List<BookingInformation> findAllBooking() {
		// TODO Auto-generated method stub
		return dao.readAllBooking();
	}

}
