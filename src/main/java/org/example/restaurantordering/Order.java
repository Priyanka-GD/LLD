package org.example.restaurantordering;

public class Order {
    Restaurant restaurant;
    public Order(RestaurantImp restaurantImp){
        this.restaurant = restaurantImp;
    }
    public void orderItem(OrderItem orderItem){
        this.restaurant.addItem(orderItem);
    }
    public  void removeItem(OrderItem orderItem){
        this.restaurant.removeItem(orderItem);
    }
    public double checkOutTotal(){
        double total = 0.0;
        for(OrderItem orderItem: this.restaurant.getOrderItemList()){
            total += orderItem.getItemPrice() * orderItem.quantity;
        }
        return total;
    }
}
