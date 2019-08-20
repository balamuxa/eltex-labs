package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.*;
import ru.eltex.app.java.lab3.ShoppingCart;


public class Generator<T extends Orders> extends ACheck {

    public Generator(T orders) {
        super(orders);
    }

    @Override
    public void run() {
//        while (fRun) {
            synchronized (getOrders()) {
                Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
                ShoppingCart<Tovar> shoppingCart = new ShoppingCart();
                System.out.println("++++++++++++++++++++++++++");
                System.out.println("Заказ");
                System.out.println("--------------------------");
                for (int i = 0; i < 1; i++) {
                    Tovar[] kraskas = new Kraska[99];
                    kraskas[i] = new Kraska();
                    kraskas[i].create();
                    Tovar[] instruments = new Instruments[99];
                    instruments[i] = new Instruments();
                    instruments[i].create();
                    shoppingCart.add(kraskas[i]);
                    shoppingCart.add(instruments[i]);
                }
                getOrders().offer(shoppingCart, credentials);
                getOrders().show();
                System.out.println("Статус заказа: " + getOrders().orderStat() + "    --вызов из generator");
            }
//            try {
//                Thread.sleep(pauseGen);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
