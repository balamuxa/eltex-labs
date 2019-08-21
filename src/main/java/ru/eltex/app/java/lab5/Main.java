package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab2.Tovar;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;
import ru.eltex.app.java.lab4.Orders;

public class Main {
    public static void main(String[] args) {

        Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
        Orders<Order> orders = new Orders();
        ShoppingCart shoppingCart = new ShoppingCart();
        Kraska[] kraskas = new Kraska[99];
//        for (int i = 0; i < 1; i++) {
            kraskas[0] = new Kraska();
            kraskas[0].create();
            shoppingCart.add(kraskas[0]);
//        }
        orders.offer(shoppingCart, credentials);
//        orders.show();


        ManagerOrderFile managerOrderFile = new ManagerOrderFile();
        managerOrderFile.saveAll(orders);
        managerOrderFile.readAll();
    }
}
