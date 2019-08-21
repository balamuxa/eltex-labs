package ru.eltex.app.java.lab2;

import java.sql.Date;

public class Order {

    private ShoppingCart shoppingCart;
    private Credentials credentials;
    private OrderStatus status;
    private Date dateCreate;
    private long timeWaiting;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public long getTimeWaiting() {
        return timeWaiting;
    }

    public long getInterval() {
        return dateCreate.getTime() + timeWaiting;
    }

    public boolean checkInterval(long time) {
        if ((this.dateCreate.getTime() + this.timeWaiting) < time) {
            return true;
        } else
            return false;
    }

    Order() {
    }

    public Order(ShoppingCart shoppingCart, Credentials credentials) {
        this.shoppingCart = shoppingCart;
        this.credentials = credentials;
        this.status = OrderStatus.WAIT;
        this.dateCreate = new Date(System.currentTimeMillis());
        this.timeWaiting = (long) (Math.random() * 30000);
//        this.timeWaiting = 5000;
    }

    public void show() {
        shoppingCart.show();
        System.out.println("Ваши данные:");
        System.out.println("--------------------------");
        credentials.show();
        System.out.println("Статус заказа:" + status);
        System.out.println("Дата создания:" + dateCreate);
        System.out.println("Время ожидания:" + timeWaiting / 1000 + " сек");

    }
}
