package com.pnx.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingInformation {
    private int id; // Unique ID
    private MeetingRoom meetingRoom; // Meeting Room
    private LocalDate date; // Date
    private LocalTime startTime; // Start time
    private LocalTime endTime; // End time
    private int bookedByUserId; // Booked by (User ID)

    public BookingInformation(int id, MeetingRoom meetingRoom, LocalDate date, LocalTime startTime, LocalTime endTime, int bookedByUserId) {
        this.id = id;
        this.meetingRoom = meetingRoom;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.bookedByUserId = bookedByUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MeetingRoom getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(MeetingRoom meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public int getBookedByUserId() {
        return bookedByUserId;
    }

    public void setBookedByUserId(int bookedByUserId) {
        this.bookedByUserId = bookedByUserId;
    }

    public String toString() {
        return "Booking ID: " + id + "\nMeeting Room: " + meetingRoom.getName() + "\nDate: " + date + "\nStart Time: " + startTime + "\nEnd Time: " + endTime + "\nBooked by User ID: " + bookedByUserId;
    }
}

