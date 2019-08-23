package ru.eltex.app.java.lab5;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.eltex.app.java.lab2.Tovar;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab4.Orders;
import ru.eltex.app.java.lab5.Deserialize.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.UUID;

public class ManagerOrderJSON extends AManageOrder {
    private Gson gson;

//    DateFormat dformat = new SimpleDateFormat("E MMM HH:mm:ss Z yyyy", Locale.ENGLISH);

    public ManagerOrderJSON() {
//        Deserialize deserialize = new Deserialize();
        gson = new GsonBuilder()
                .registerTypeAdapter(Orders.class, new DeserializeOrders())
                .registerTypeAdapter(Order.class, new DeserializeOrder())
                .registerTypeAdapter(Tovar.class, new DeserializeTovar())
                .setDateFormat("yyyy E MMM HH:mm:ss")
                .setPrettyPrinting()
                .create();
    }


    @Override
    public Order readById(HashSet<UUID> uuid) {
        return null;
    }

    @Override
    public void saveById(Order order) {

    }

    @Override
    public Orders readAll() {
        Gson gson1 = new GsonBuilder()
//                .setDateFormat("E MMM HH:mm:ss Z yyyy")
//                .setDateFormat(DateFormat.SHORT, dformat)
                .setDateFormat("yyyy E MMM HH:mm:ss")


                .setPrettyPrinting().create();

        try (FileReader reader = new FileReader(file2)) {
            // Convert JSON File to Java Object

//            Orders orders = gson.fromJson(reader, Orders.class);
            Orders orders1 = gson1.fromJson(reader, Orders.class);
//            orders1.show();
//            System.out.println(gson.toJson(orders));
            System.out.println(gson1.toJson(orders1));
            // print staff object
            //System.out.println(staff);
//            orders.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAll(Orders orders) {
//        Gson gson = new Gson();
        Gson gson1 = new GsonBuilder()
//                .setDateFormat(DateFormat.SHORT, DateFormat.SHORT)
.setDateFormat("yyyy E MMM HH:mm:ss")
//                .setDateFormat("E MMM HH:mm:ss Z yyyy")
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
