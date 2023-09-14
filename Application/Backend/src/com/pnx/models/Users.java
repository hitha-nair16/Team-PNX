package com.pnx.models;

public class Users {
    private int id; // Unique ID
    private String name; // Name
    private String email; // Email
    private String phone; // Phone
    private double credits; // Credits
    private UserRole role; // Role (Admin/Manager/Member)

    public enum UserRole {
        ADMIN("Admin"),
        MANAGER("Manager"),
        MEMBER("Member");

        private final String roleName;

        UserRole(String roleName) {
            this.roleName = roleName.toLowerCase(); // Store in lowercase
        }

        public String getRoleName() {
            return roleName;
        }

        public static UserRole fromString(String roleName) {
            for (UserRole role : UserRole.values()) {
                if (role.roleName.equalsIgnoreCase(roleName)) {
                    return role;
                }
            }
            throw new IllegalArgumentException("Invalid UserRole: " + roleName);
        }
    }

    public Users(int id, String name, String email, String phone, double credits, UserRole role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.credits = credits;
        this.role = role;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String toString() {
        return "User ID: " + id + "\nName: " + name + "\nEmail: " + email + "\nPhone: " + phone + "\nCredits: " + credits + "\nRole: " + role.getRoleName();
    }
}
