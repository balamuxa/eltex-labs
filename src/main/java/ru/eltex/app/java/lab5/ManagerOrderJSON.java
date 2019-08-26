package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab4.Orders;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {

    @Override
    public Order readById(HashSet<UUID> uuid) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy E MMM HH:mm:ss")
                .setPrettyPrinting()
                .create();
        try (FileReader reader = new FileReader(file2)) {
            Order order = gson.fromJson(reader, Order.class);
            if (order.getSetId().equals(uuid))
                System.out.println(gson.toJson(order));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveById(Order order) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy E MMM HH:mm:ss")
                .setPrettyPrinting()
                .create();
        try (FileWriter writer = new FileWriter(file2)) {
            gson.toJson(order, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy E MMM HH:mm:ss")
                .setPrettyPrinting()
                .create();
        try (FileReader reader = new FileReader(file2)) {
            Orders orders = gson.fromJson(reader, Orders.class);
            System.out.println(gson.toJson(orders));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAll(Orders orders) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy E MMM HH:mm:ss")
                .setPrettyPrinting()
                .create();
        try (FileWriter writer = new FileWriter(file2)) {
            gson.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}