package com.pnx.models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class MeetingRoom {
    
    private String name; // Unique Name
    private int seatingCapacity; // Seating Capacity
    private double ratings; // Ratings (based on feedbacks)
    private Set<String> amenitiesAvailable; // Amenities Available
    private double perHourCost; // Per hour cost (in credits)

    private double managerCredits; // Manager's credits (2000 points)
    private LocalDate lastCreditRenewalDate; // Store the last date when manager credits were renewed

    public MeetingRoom(String name, int seatingCapacity, double ratings, Set<String> amenitiesAvailable) {
       
        this.name = name;
        this.seatingCapacity = seatingCapacity;
        this.ratings = ratings;
        this.amenitiesAvailable = amenitiesAvailable;
        this.calculatePerHourCost();
        this.managerCredits = 2000; // Initialize manager's credits to 2000 points
        this.lastCreditRenewalDate = LocalDate.now(); // Initialize with the current date
    }

  

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public Set<String> getAmenitiesAvailable() {
        return amenitiesAvailable;
    }

    public void setAmenitiesAvailable(Set<String> amenitiesAvailable) {
        this.amenitiesAvailable = amenitiesAvailable;
        this.calculatePerHourCost();
    }

    public double getPerHourCost() {
        return perHourCost;
    }

    // Check if manager credits need to be renewed (every Monday)
    private boolean shouldRenewManagerCredits() {
        LocalDate currentDate = LocalDate.now();
        return lastCreditRenewalDate.getDayOfWeek() != DayOfWeek.MONDAY && currentDate.getDayOfWeek() == DayOfWeek.MONDAY;
    }

    // Renew manager credits to 2000 points (if needed)
    public void renewManagerCredits() {
        if (shouldRenewManagerCredits()) {
            // Renew credits to 2000
            if (isManagerMeetingRoom()) {
                managerCredits = 2000;
            }
            lastCreditRenewalDate = LocalDate.now();
        }
    }

    // Check if this is a manager meeting room
    private boolean isManagerMeetingRoom() {
        return seatingCapacity >= 10;
    }

    // Calculate per hour cost based on seating capacity and amenities
    private void calculatePerHourCost() {
        double cost = 0;

        if (seatingCapacity <= 5) {
            cost += 0; // No credits for seating capacity <= 5
        } else if (seatingCapacity > 5 && seatingCapacity < 10) {
            cost += 10; // 10 credits for seating capacity > 5 < 10
        } else {
            cost += 20; // 20 credits for seating capacity > 10
        }

        for (String amenity : amenitiesAvailable) {
            switch (amenity) {
                case "Projector":
                    cost += 5;
                    break;
                case "Wi-Fi Connection":
                    cost += 10;
                    break;
                case "Conference call facility":
                    cost += 15;
                    break;
                case "Whiteboard":
                    cost += 5;
                    break;
                case "Water dispenser":
                    cost += 5;
                    break;
                case "TV":
                    cost += 10;
                    break;
                case "Coffee machine":
                    cost += 10;
                    break;
                default:
                    break;
            }
        }

        perHourCost = cost;
    }

    public String toString() {
        return "Name: " + name + "\nSeating Capacity: " + seatingCapacity +
                "\nRatings: " + ratings + "\nAmenities Available: " + amenitiesAvailable +
                "\nPer Hour Cost (in credits): " + perHourCost;
    }
}

