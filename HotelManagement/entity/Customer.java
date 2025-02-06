package com.cts.HotelManagement.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate checkInDate;

    @Column(nullable = false)
    private String roomType;

    @Column(nullable = false)
    private String bedType;

    @Column(nullable = false)
    private String status; // Checked-in, Checked-out
    
    @Column(nullable = false)
    private String roomNumber; // Checked-in, Checked-out

    public Customer() {}

    public Customer(String name, String mobile, String email, LocalDate checkInDate, String roomType, String bedType, String status, String roomNumber) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.checkInDate = checkInDate;
        this.roomType = roomType;
        this.bedType = bedType;
        this.status = status;
        this.roomNumber=roomNumber;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate) { this.checkInDate = checkInDate; }
    public String getRoomType() { return roomType; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
    public String getBedType() { return bedType; }
    public void setBedType(String bedType) { this.bedType = bedType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRoomNumber() {return roomNumber;}
    public void setRoomNumber(String roomNumber) {this.roomNumber=roomNumber;}
}
