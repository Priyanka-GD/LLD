package org.example.packagedelivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryAgent {
    private String agentId;
    private DeliveryHub assignedHub;
    private List<Package> assignedPackages = new ArrayList<>();

    public DeliveryAgent(String agentId, DeliveryHub hub) {
        this.agentId = agentId;
        this.assignedHub = hub;
    }

    public void assignPackage(Package pkg) {
        assignedPackages.add(pkg);
    }

    public List<Package> getAssignedPackages() {
        return assignedPackages;
    }

    public String getAgentId() {
        return agentId;
    }
}
