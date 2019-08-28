package ru.eltex.app.java.lab7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;
import ru.eltex.app.java.lab4.Orders;

import java.util.Collections;
import java.util.UUID;

@RestController
public class Controller {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy E MMM HH:mm:ss")
            .setPrettyPrinting()
            .create();

    Logger logger = LogManager.getLogger(Controller.class);

    Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
    Orders orders = new Orders();
    ShoppingCart shoppingCart = new ShoppingCart();
    ShoppingCart shoppingCart1 = new ShoppingCart();
    ShoppingCart shoppingCart2 = new ShoppingCart();
    Kraska[] kraskas = new Kraska[99];

    public class Person {

        public String name;
        public int age;

        Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    @RequestMapping("/person")
    public Object person() {
        logger.info("person");
        return new Person("asd", 11);
    }

    @RequestMapping("/")
    public Object create() {
        logger.info("create");
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
        return "offer";
    }

    @RequestMapping("/readAll")
    public Object readAll() {
        logger.info("readAll");
        return gson.toJson(orders);
//        return orders;
    }

    @RequestMapping("/readByID")
    public Object readByID(String id) {
        logger.info("readByID");
//        Order order = orders.getOrdersForJSON(id);
//        return order;
        return gson.toJson(orders.getOrdersID(id));
    }

    @RequestMapping("/addToCard")
    public Object addToCard(long id) {
        logger.info("addToCard");
        UUID iD = new UUID(id, id);
        orders.getShoppingCart(Collections.singleton(iD));
        kraskas[0] = new Kraska();
        kraskas[0].create();
        shoppingCart.add(kraskas[0]);
        return kraskas[0].getUUIDs().toString();
    }

    @RequestMapping("/delByID")
    public Object delByID(String id) {
        logger.info("delByID");
        Order order = orders.getOrdersID(id);
        if (order == null)
            throw new NullPointerException();
        orders.delete(id);
        return "0";
    }

    @RequestMapping("/checkCart")
    public Object checkCart() {
        logger.info("checkCart");
        return gson.toJson(shoppingCart);
    }
}
