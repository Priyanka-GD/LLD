package org.example.vendingmachine;

class ChocolateBar implements FoodItem {
    private String name;
    private int count;
    private int price;

    public ChocolateBar(String name, int count, int price) {
        this.name = name;
        this.count = count;
        this.price = price;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getCount() { return count; }

    @Override
    public void decrementCount(int removeCnt) { this.count -= removeCnt; }

    @Override
    public int getPrice() { return price; }
}
