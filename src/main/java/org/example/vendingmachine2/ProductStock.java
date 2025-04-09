package org.example.vendingmachine2;

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
