package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab4.Orders;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {

    DateFormat dformat = new SimpleDateFormat("E MMM HH:mm:ss Z yyyy", Locale.ENGLISH);

    @Override
    public Order readById(HashSet<UUID> uuid) {
        return null;
    }

    @Override
    public void saveById(Order order) {

    }

    @Override
    public Orders readAll() {
        Gson gson = new GsonBuilder()
                .setDateFormat("E MMM HH:mm:ss Z yyyy").create();

        try (FileReader reader = new FileReader(file2)) {
            // Convert JSON File to Java Object
            Orders orders = gson.fromJson(reader, Orders.class);
            // print staff object
            //System.out.println(staff);
            orders.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAll(Orders orders) {
//        Gson gson = new Gson();
        Gson gson1 = new GsonBuilder()
                .setDateFormat("E MMM HH:mm:ss Z yyyy")
                .setPrettyPrinting()
                .create();
        // Java objects to File
        try (FileWriter writer = new FileWriter(file2)) {
//            gson.toJson(orders, writer);
            gson1.toJson(orders, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
