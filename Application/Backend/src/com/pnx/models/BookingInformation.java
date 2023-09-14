package com.pnx.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingInformation {
    private int id; // Unique ID
    private String meetingRoom; // Meeting Room
    private String date; // Date
    private String startTime; // Start time
    private String endTime; // End time
    private int bookedByUserId; // Booked by (User ID)

    public BookingInformation(int id, String meetingroom2, String date2, String stime, String etime, int bookedByUserId) {
        this.id = id;
        this.meetingRoom = meetingroom2;
        this.date = date2;
        this.startTime = stime;
        this.endTime = etime;
        this.bookedByUserId = bookedByUserId;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(String meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getBookedByUserId() {
		return bookedByUserId;
	}

	public void setBookedByUserId(int bookedByUserId) {
		this.bookedByUserId = bookedByUserId;
	}

	@Override
	public String toString() {
		return "BookingInformation [id=" + id + ", meetingRoom=" + meetingRoom + ", date=" + date + ", startTime="
				+ startTime + ", endTime=" + endTime + ", bookedByUserId=" + bookedByUserId + "]";
	}
	
	

}

