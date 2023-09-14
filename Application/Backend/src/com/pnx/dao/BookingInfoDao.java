package com.pnx.dao;
import com.pnx.models.*;
import java.util.List;

public interface BookingInfoDao {
	public BookingInformation readBooking(int bookingId);
public List<BookingInformation> readAllBooking();
}
