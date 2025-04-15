package org.example.packagedelivery;

public class DeliveryHub {
    private String hubId;
    private Location location;

    public DeliveryHub(String hubId, Location location) {
        this.hubId = hubId;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getHubId() {
        return hubId;
    }
}
