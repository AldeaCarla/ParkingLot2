package com.parking.parkinglot.common;

public class UsersDto {
    private Long id;
    private String username;
    private String email;

    public UsersDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }

    public static class CarDto {
        Long id;
    
        public Long getId() {
            return id;
        }
    
        String licensePlate;
    
        public String getLicensePlate() {
            return licensePlate;
        }
    
        String parkingSpot;
    
        public String getParkingSpot() {
            return parkingSpot;
        }
    
        String ownerName;
    
        public String getOwnerName() {
            return ownerName;
        }
    }
}
