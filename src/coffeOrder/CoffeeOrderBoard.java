package coffeOrder;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {
    private List<Order> orders;
    private int nextOrderNumber;

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        nextOrderNumber = 1;
    }

    public void addOrder(Order order) {
        order.setOrderNumber(nextOrderNumber);
        orders.add(order);
        nextOrderNumber++;
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order nextOrder = orders.get(0);
            System.out.println("Delivering order: " + nextOrder.getOrderNumber() + " | " + nextOrder.getCustomerName());
            orders.remove(0);
        } else {
            System.out.println("No orders to deliver.");
        }
    }

    public void deliverN(int orderNumber) {
        int index = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNumber() == orderNumber) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            Order order = orders.get(index);
            System.out.println("Delivering order: " + order.getOrderNumber() + " | " + order.getCustomerName());
            orders.remove(index);
        } else {
            System.out.println("Order with number " + orderNumber + " not found.");
        }
    }

    public void draw() {
        System.out.println("======================");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
        System.out.println("======================");
    }
}
