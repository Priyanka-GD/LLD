package org.example.vendingmachine2;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

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
