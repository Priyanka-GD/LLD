## Design Patterns Used

### Factory Pattern (Implied)

Location.fromAddress(String address) acts like a factory method converting an address into a Location object.

Could be made more explicit by creating a LocationFactory if needed.

### Strategy Pattern (Potential Extension)

distanceTo() can be part of a DistanceStrategy interface (e.g., for Haversine vs Euclidean distance).

This decouples logic and allows flexible distance computations.

Singleton Pattern (Potential Extension)

A centralized PackageAssignmentService or HubManager could be implemented as a singleton to manage shared state.

### Builder Pattern (Optional Extension)

For constructing complex User or Package objects with optional fields.

#### SOLID Principles Applied
S – Single Responsibility Principle

Each class has one responsibility:

User → stores user data

Location → represents coordinates & computes distances

Package → represents a deliverable item

DeliveryHub → holds hub info

DeliveryAgent → manages assigned packages

PackageAssignment → assigns packages to hubs

O – Open/Closed Principle

You can extend Location to use different distance algorithms without modifying existing logic.

Add new types of DeliveryAgent or DeliveryHub without touching core logic.

L – Liskov Substitution Principle

If we extend Location or User, the child classes can be used wherever their parent is expected (no violation currently).

I – Interface Segregation Principle

Not yet applied as no interfaces are explicitly used.

Could be introduced: e.g., DistanceCalculator, HubSelectorStrategy.

D – Dependency Inversion Principle

Currently tightly coupled.

Can be improved by injecting dependencies like hub list, distance calculator, etc., into PackageAssignment to follow this principle.