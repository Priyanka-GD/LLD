package org.example.packagedelivery;

public class User {
    private String username;
    private String email;
    private String shippingAddress;
    private String password;

    public User(String username, String email, String shippingAddress, String password) {
        this.username = username;
        this.email = email;
        this.shippingAddress = shippingAddress;
        this.password = password;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }
}
