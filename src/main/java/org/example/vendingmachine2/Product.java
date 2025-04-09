package org.example.vendingmachine2;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// Product with unique ID
public class Product {
    private String id;
    private String name;
    private int price;

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

// Wrapper to hold product and quantity
class ProductStock {
    private Product product;
    private int quantity;

    public ProductStock(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Inventory {
    private ConcurrentHashMap<String, ProductStock> inventoryMap = new ConcurrentHashMap<>();

    public void addProduct(Product product, int quantity) {
        inventoryMap.put(product.getId(), new ProductStock(product, quantity));
    }

    public boolean isAvailable(String productId, int quantity) {
        if (!inventoryMap.containsKey(productId)) {
            throw new NoSuchElementException("Product ID not found");
        }
        return inventoryMap.get(productId).getQuantity() >= quantity;
    }

    public Product getProductById(String productId) {
        if (!inventoryMap.containsKey(productId)) {
            throw new NoSuchElementException("Product not found");
        }
        return inventoryMap.get(productId).getProduct();
    }

    public void updateQuantity(String productId, int quantity) {
        inventoryMap.get(productId).setQuantity(quantity);
    }

    public void removeProduct(String productId) {
        inventoryMap.remove(productId);
    }

    public int getQuantity(String productId) {
        return inventoryMap.get(productId).getQuantity();
    }
}

interface VendingMachineState {
    void handleRequest(VendingMachine machine);

    String getStateName();
}

class IdleState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Machine is idle. Waiting for order.");
        machine.setState(new ReadyState());
    }

    @Override
    public String getStateName() {
        return "IDLE";
    }
}

class ReadyState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Machine is ready to dispense.");
        machine.setState(new DispensingState());
    }

    @Override
    public String getStateName() {
        return "READY";
    }
}

class DispensingState implements VendingMachineState {
    @Override
    public void handleRequest(VendingMachine machine) {
        System.out.println("Dispensing items...");
        machine.setState(new IdleState());
    }

    @Override
    public String getStateName() {
        return "DISPENSING";
    }
}

class VendingMachine {
    Inventory inventory;
    static VendingMachine instance;
    private VendingMachineState currentState;

    public VendingMachine() {
        this.inventory = new Inventory();
        currentState = new IdleState();
    }
    public static synchronized VendingMachine getInstance() {
        if (instance == null) {
            instance = new VendingMachine();
        }
        return instance;
    }
    public void setState(VendingMachineState vendingMachineState) {
        this.currentState = vendingMachineState;
    }

    public String getCurrentStateName() {
        return currentState.getStateName();
    }

    public void handleState() {
        currentState.handleRequest(this);
    }
}

class OrderItem {
    private String productId;
    private int quantity;

    public OrderItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}

class OrderProcessor {

    public static double getTotal(List<OrderItem> orderItems, VendingMachine machine){
        machine.handleState();
        double total = 0.0;
        for (OrderItem item : orderItems) {
            String productId = item.getProductId();
            int quantity = item.getQuantity();
            if (!machine.inventory.isAvailable(productId, quantity)) {
                throw new IllegalArgumentException("Product ID " + productId + " is not available in required quantity");
            }

            Product product = machine.inventory.getProductById(productId);
            total += product.getPrice() * quantity;
        }
        return total;
    }
    public static void processOrder(VendingMachine machine, List<OrderItem> orderItems) {
        for (OrderItem item : orderItems) {
            String productId = item.getProductId();
            int quantity = item.getQuantity();

            int remainingQty = machine.inventory.getQuantity(productId) - quantity;
            if (remainingQty == 0) {
                machine.inventory.removeProduct(productId);
            } else {
                machine.inventory.updateQuantity(productId, remainingQty);
            }
        }
        machine.handleState(); // Ready -> Dispensing
        machine.handleState(); // Dispensing -> Idle
    }
}

interface PaymentStrategy {
    void pay(double amount);

    void collectPayment();
}

class PaypalStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " via PayPal.");
    }

    @Override
    public void collectPayment() {
        System.out.println("Payment collected using PayPal.");
    }
}

