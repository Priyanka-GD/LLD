package org.example.packagedelivery;

import java.util.*;

public class PackageAssignment {
    public static DeliveryHub assignToNearestHub(Package pkg, List<DeliveryHub> hubs) {
        PriorityQueue<DeliveryHub> minHeap = new PriorityQueue<>(Comparator.comparingDouble(
                hub -> pkg.getDeliveryLocation().distanceTo(hub.getLocation())
        ));

        minHeap.addAll(hubs);
        return minHeap.peek(); // Nearest hub
    }

    public static void main(String[] args) {
        User user = new User("john_doe", "john@example.com", "123 Main St, NY", "password123");
        Package pkg = new Package("PKG001", user);

        List<DeliveryHub> hubs = Arrays.asList(
                new DeliveryHub("HUB1", new Location(40.7128, -74.0060)),
                new DeliveryHub("HUB2", new Location(34.0522, -118.2437)),
                new DeliveryHub("HUB3", new Location(37.7749, -122.4194))
        );

        DeliveryHub nearestHub = assignToNearestHub(pkg, hubs);
        System.out.println("Package assigned to hub: " + nearestHub.getHubId());

        // Assign to delivery agent
        DeliveryAgent agent = new DeliveryAgent("AGENT1", nearestHub);
        agent.assignPackage(pkg);
    }
}
