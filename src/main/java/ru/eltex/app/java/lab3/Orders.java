package ru.eltex.app.java.lab3;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.OrderStatus;

import java.util.*;

public class Orders<T extends Order> {

    private List<T> orders;
    private Map<Date, T> dateOrder;

    public Orders() {
        this.orders = new LinkedList<>();
        this.dateOrder = new LinkedHashMap<>();
    }

    public Orders(List<T> orders) {
        this.orders = orders;
    }

    public void offer(ShoppingCart cart, Credentials user) {
        Order order = new Order(cart, user);
        orders.add((T) order);
        dateOrder.put(new Date(System.currentTimeMillis()), (T) order);
    }

    public void checkTime() {
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.WAIT &&
                    order.checkInterval(System.currentTimeMillis())) {
                order.setStatus(OrderStatus.DONE);
            }
        }
    }

    /*обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан»*/
    public void checkDone() {
        for (Order order : orders) {
            if (order.getStatus() == OrderStatus.DONE && order.checkInterval(System.currentTimeMillis())) {
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

    public void show() {
        for (Order order : orders) {
            order.show();
            System.out.println("--------------------------");
        }
    }
}
