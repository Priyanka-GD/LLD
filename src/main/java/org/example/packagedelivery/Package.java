package org.example.packagedelivery;

public class Package {
    private String packageId;
    private User user;
    private Location deliveryLocation;

    public Package(String packageId, User user) {
        this.packageId = packageId;
        this.user = user;
        this.deliveryLocation = Location.fromAddress(user.getShippingAddress());
    }

    public Location getDeliveryLocation() {
        return deliveryLocation;
    }

    public String getPackageId() {
        return packageId;
    }
}
