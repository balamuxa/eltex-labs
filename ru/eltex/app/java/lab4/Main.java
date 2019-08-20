package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.Credentials;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab2.Instruments;
import ru.eltex.app.java.lab2.Tovar;
import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab3.ShoppingCart;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        Orders<Order> orders = new Orders();
        Generator gen = new Generator(orders);

        Thread generator1 = new Thread(gen);
        Thread generator2 = new Thread(gen);
        generator1.start();
        generator1.join(500);
        generator2.start();
        generator2.join(500);
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gen.offThread();

//        System.out.println(orders.orderStat());
//        Thread checkTime = new Thread(new CheckTime(orders, 1000));
//        checkTime.start();


//        System.out.println(orders.orderStat());
//        Thread checkDone = new Thread(new CheckDone(orders, 1000));
//        checkDone.start();
//        System.out.println(orders.orderStat());


//        while (true) {
//            System.out.println(orders.orderStat());
//            System.out.println(orders.timeWait());
//            Thread.sleep(1500);
//        }
    }
}

