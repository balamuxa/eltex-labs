package ru.eltex.app.java.lab4;

import com.google.gson.annotations.SerializedName;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.OrderStatus;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;

import java.io.Serializable;
import java.util.*;

public class Orders<T extends Order> implements Serializable {

//    @SerializedName("Заказы")
    private List<T> orders;
//    @SerializedName("Дата заказа")
    private Map<Date, T> dateOrder;

    public Orders() {
        this.orders = new LinkedList<>();
        this.dateOrder = new LinkedHashMap<>();
    }

    public Orders(List<T> orders) {
        this.orders = orders;
    }

    public Orders(List<T> orders, Map<Date, T> dateOrder) {
        this.orders = orders;
        this.dateOrder = dateOrder;
    }

    public Orders(LinkedList<Order> ordersList, LinkedHashMap<java.sql.Date, Order> ordersHashMap) {

    }


    public void offer(ShoppingCart cart, Credentials user) {
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(order.getDateCreate(), (T) order);
//        dateOrder.put(new Date(System.currentTimeMillis()), (T) order);
    }

    public void checkTime() {
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.WAIT) {
                order.setStatus(OrderStatus.DONE);
            }
        }
    }

    public void checkDone() {
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DONE) {
                orders.remove(order);
                dateOrder.remove(order);
            }
        }
    }

    public long timeWait() {
        for (Order order : orders) {
            return order.getTimeWaiting();
        }
        return 0;
    }

    public OrderStatus orderStat() {
        for (Order order : orders) {
            return order.getStatus();
        }
        return null;
    }

    public Order getOrders(int i) {
        return orders.get(i);
    }

    public Orders show() {
        for (Order order : orders) {
            order.show();
            System.out.println("--------------------------");
        }
        return null;
    }
}
