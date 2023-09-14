package com.pnx.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Meeting {
    private int id; // Unique ID
    private String title; // Title
    private int organizedByUserId; // Organized by (User ID)
    private LocalDate meetingDate; // Meeting Date
    private LocalTime startTime; // Start time
    private LocalTime endTime; // End time
    private MeetingType type; // Type (of Meeting)
    private List<Users> members; // List of members attending the meeting
    private BookingInformation bookingInformation; // Information of Meeting room booking

    public enum MeetingType {
        CLASSROOM_TRAINING("Classroom Training"),
        ONLINE_TRAINING("Online Training"),
        CONFERENCE_CALL("Conference Call"),
        BUSINESS("Business");

        private final String typeName;

        MeetingType(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }
    }

    public Meeting(
        int id, String title, int organizedByUserId, LocalDate meetingDate,
        LocalTime startTime, LocalTime endTime, String type,
        List<Users> members, BookingInformation bookingInformation
    ) {
        this.id = id;
        this.title = title;
        this.organizedByUserId = organizedByUserId;
        this.meetingDate = meetingDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = getMeetingType(type);
        this.members = members;
        this.bookingInformation = bookingInformation;
    }
    
    public Meeting() {
		// TODO Auto-generated constructor stub
	}

	public MeetingType getMeetingType(String type) {
    	switch(type) {
    	 	case "Classroom Training":
    	 		return MeetingType.CLASSROOM_TRAINING;
    	 	case "Online Training":
    	 		return MeetingType.ONLINE_TRAINING;
    	 	case "Conference Call":
    	 		return MeetingType.CONFERENCE_CALL;
    	 	case "Business":
    	 		return MeetingType.BUSINESS;
    	 	default:
    	 		return MeetingType.CLASSROOM_TRAINING;
    	}
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrganizedByUserId() {
        return organizedByUserId;
    }

    public void setOrganizedByUserId(int organizedByUserId) {
        this.organizedByUserId = organizedByUserId;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
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

    public MeetingType getType() {
        return type;
    }

    public void setType(MeetingType type) {
        this.type = type;
    }

    public List<Users> getMembers() {
        return members;
    }

    public void setMembers(List<Users> members) {
        this.members = members;
    }

    public BookingInformation getBookingInformation() {
        return bookingInformation;
    }

    public void setBookingInformation(BookingInformation bookingInformation) {
        this.bookingInformation = bookingInformation;
    }

    public String toString() {
        return "Meeting ID: " + id + "\nTitle: " + title + "\nOrganized by User ID: " + organizedByUserId +
            "\nMeeting Date: " + meetingDate + "\nStart Time: " + startTime + "\nEnd Time: " + endTime +
            "\nType: " + type.getTypeName();
    }
}

