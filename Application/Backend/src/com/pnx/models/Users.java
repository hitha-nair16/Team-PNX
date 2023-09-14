package com.pnx.models;

public class Users {
    private int id; // Unique ID
    private String name; // Name
    private String email; // Email
    private String phone; // Phone
    private double credits; // Credits
    private String role; // Role (Admin/Manager/Member)

    
    

	public Users(int id, String name, String email, String phone, double credits, String role2) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.credits = credits;
        this.role = role2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", credits=" + credits
				+ ", role=" + role + "]";
	}

    
}
