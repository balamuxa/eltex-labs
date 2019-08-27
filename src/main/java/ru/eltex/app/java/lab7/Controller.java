package ru.eltex.app.java.lab7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab2.Tovar;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;
import ru.eltex.app.java.lab4.Orders;

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
        return new Person("asd", 11);
    }

    @RequestMapping("/")
    public Object create() {

        for (int i = 0; i < Tovar.counter; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart1.add(kraskas[i]);
        }
        for (int i = 0; i < Tovar.counter; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart2.add(kraskas[i]);
        }
        orders.offer(shoppingCart1, credentials);
        orders.offer(shoppingCart2, credentials);

//        managerOrderJSON.saveAll(orders);
        return orders;
    }

    @RequestMapping("/readAll")
    public Object readAll() {
//        return gson.toJson(orders);
        return orders;
    }

    @RequestMapping("/readByID")
    public Object readByID(String id) {
        Order order = orders.getOrdersForJSON(id);
        return order;
    }

    @RequestMapping("/addToCard")
    public Object addToCard(String id) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Credentials credentials = new Credentials("petrov", "boba", "bobing", "g@a.r");
        shoppingCart.add(kraskas[Tovar.counter + 1]);
        return shoppingCart;
    }
}
