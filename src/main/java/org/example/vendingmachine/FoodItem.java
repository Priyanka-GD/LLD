package org.example.vendingmachine;

interface FoodItem {
    String getName();
    int getCount();
    void decrementCount(int removeCnt);
    int getPrice();
}