package ru.eltex.app.java.lab7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;
import ru.eltex.app.java.lab4.Orders;
import ru.eltex.app.java.lab5.ManagerOrderJSON;

import java.util.HashSet;
import java.util.UUID;

@RestController
public class Controller {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy E MMM HH:mm:ss")
            .setPrettyPrinting()
            .create();

    //    ManagerOrderJSON managerOrderJSON = new ManagerOrderJSON();
    Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
    Orders orders = new Orders();
    ShoppingCart shoppingCart1 = new ShoppingCart();
    ShoppingCart shoppingCart2 = new ShoppingCart();
    Kraska[] kraskas = new Kraska[99];

    @GetMapping("/")
    public String create() {

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

//        managerOrderJSON.saveAll(orders);
        return "";
    }

    @GetMapping("/readAll")
    public String readAll() {
        return gson.toJson(orders);
    }

    @GetMapping("/readByID")
    public String readByID(String uuid) {
        Order order = orders.getOrdersForJSON(uuid);
        return gson.toJson(order);
    }
}
