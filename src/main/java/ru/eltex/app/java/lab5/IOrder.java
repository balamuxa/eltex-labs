package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab4.Orders;

public interface IOrder {

    void readById();

    void saveById();

    Orders readAll();

    void saveAll(Orders orders);
}
