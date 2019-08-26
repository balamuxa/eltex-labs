package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab3.ShoppingCart;
import ru.eltex.app.java.lab4.Orders;

public class Main {

    public static void main(String[] args) {

        Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
        Orders orders = new Orders();
        ShoppingCart shoppingCart1 = new ShoppingCart();
        ShoppingCart shoppingCart2 = new ShoppingCart();
        Kraska[] kraskas = new Kraska[99];
        for (int i = 0; i < 2; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart1.add(kraskas[i]);
        }
        for (int i = 0; i < 2; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart2.add(kraskas[i]);
        }
        orders.offer(shoppingCart1, credentials);
        orders.offer(shoppingCart2, credentials);
        orders.show();

        ManagerOrderFile managerOrderFile = new ManagerOrderFile();

        /*Сохранение и чтение заказов в двоичный фаил*/
//        managerOrderFile.saveAll(orders);
//        managerOrderFile.readAll();

        /*Сохранение и чтение по ID*/
//        Order order = orders.getOrders(1);
//        managerOrderFile.saveById(order);
//        managerOrderFile.readById(order.getSetId());

        ManagerOrderJSON managerOrderJSON = new ManagerOrderJSON();

        /*Сохранеие и чтение заказов в JSON*/
        managerOrderJSON.saveAll(orders);
//        managerOrderJSON.readAll();

//        /*Сохранение и чтение по ID в JSON*/
//        Order order = orders.getOrders(1);
//        managerOrderJSON.saveById(order);
//        managerOrderJSON.readById(order.getSetId());
    }
}
