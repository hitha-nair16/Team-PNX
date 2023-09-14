package com.pnx.services;

import java.util.List;

import com.pnx.models.BookingInformation;

public interface BookingInfoService {
	public BookingInformation findBooking(int bookingId);
	public List<BookingInformation> findAllBooking();
}
