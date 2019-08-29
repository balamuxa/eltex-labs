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

    public static final String person = "/person";
    public static final String create = "/create";
    public static final String readAll = "/readAll";
    public static final String readByID = "/readByID";
    public static final String addToCart = "/addToCart";
    public static final String delById = "/delByID";
    public static final String checkCart = "/checkCart";

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

    @RequestMapping(value = person)
    public Object person() {
        logger.info("person");
        return new Person("asd", 11);
    }

    @RequestMapping(value = create)
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

    @RequestMapping(value = readAll)
    public Object readAll() {
        logger.info("readAll");
        return gson.toJson(orders);
//        return orders;
    }

    @RequestMapping(value = readByID)
    public Object readByID(String id) {
        logger.info("readByID");
//        Order order = orders.getOrdersForJSON(id);
//        return order;
        return gson.toJson(orders.getOrdersID(id));
    }

    @RequestMapping(value = addToCart)
    public Object addToCart(long id) {
        logger.info("addToCart");
        UUID iD = new UUID(id, id);
        orders.getShoppingCart(Collections.singleton(iD));
        Kraska kraskas = new Kraska();
        kraskas.create();
        shoppingCart.add(kraskas);
        return kraskas.getUUID();
    }

    @RequestMapping(value = delById)
    public Object delByID(String id) {
        logger.info("delByID");
        Order order = orders.getOrdersID(id);
        if (order == null)
            throw new NullPointerException();
        orders.delete(id);
        return "0";
    }

    @RequestMapping(value = checkCart)
    public Object checkCart() {
        logger.info("checkCart");
        return gson.toJson(shoppingCart);
    }

    @RequestMapping(value = "/*", headers = {"!/person", "!/create", "!/readAll", "!/readByID",
            "!/addToCart", "!/delByID", "!/checkCart"})
    public Object illegalArgumentException() {
        throw new IllegalArgumentException();
    }
}
