package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab4.Orders;
import ru.eltex.app.java.lab3.Order;


import java.util.HashSet;
import java.util.UUID;

public interface IOrder {

    Order readById(HashSet<UUID> uuid);

    void saveById(Order order);

    Orders readAll();

    void saveAll(Orders orders);
}
