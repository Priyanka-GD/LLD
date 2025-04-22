Design a restaurant food ordering and rating system like Zomato, Swiggy, Uber eats etc.

Functional Requirement :

1. User should be able to order food from restaurants
2. User get to add, delete (modify) food items
3. User get to rate food
4. Restaurants displayed based on rating
6. User makes payment after checking out
7. After payment confirmation, order gets processed

SOLID

### 1. Single Responsibility

Each class has a clear, single responsibility: 
#### OrderItem → represents item details
#### RestaurantImp → manages order items
#### Order → handles order operations
#### RestaurantStrategyByRating → sorting logic

### 2. Open/Closed Principle

You can add new sorting strategies (e.g., RestaurantStrategyByDistance) 
without changing existing code—thanks to the strategy interface.

### 3. Liskov's substituition

RestaurantImp can be used wherever Restaurant is expected—adhering to LSP.

### 4. Interface Segregation

No fat interfaces—each interface is lean (Restaurant, RestaurantStrategy) and only exposes necessary methods.

### 5. Dependency Injection

Order depends on the abstraction Restaurant, not a concrete class like RestaurantImp. This promotes loose coupling 
and makes it easier to test or swap implementations.

Design Pattern

1. Strategy Pattern
   Used in: RestaurantStrategy interface and its implementation RestaurantStrategyByRating.

Purpose: Allows runtime selection of restaurant sorting logic without modifying core business logic.

Future Scope :

### 🧩 Recommended Design Patterns

| **Design Pattern**     | **Recommended Use Case** |
|------------------------|--------------------------|
| **Factory Pattern**    | Create restaurant instances via a `RestaurantFactory` class. |
| **Builder Pattern**    | Construct complex `OrderItem` objects with optional fields. |
| **Observer Pattern**   | Notify billing, delivery, or inventory systems after checkout. |
| **Decorator Pattern**  | Add optional customizations to order items (e.g., “extra cheese”, toppings). |
