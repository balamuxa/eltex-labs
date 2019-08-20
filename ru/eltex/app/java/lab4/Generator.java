package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab2.*;
import ru.eltex.app.java.lab3.ShoppingCart;


public class Generator<T extends Orders> extends ACheck {

//    private Orders orders = new Orders();
//    public boolean fRun = true;
//    public long pause = 1000;

    public Generator(T orders){//,long pause,boolean fRun) {
        super(orders);
        this.fRun = true;
    }

//    public void offThread() {
//            fRun = false;
//    }

    @Override
    public void run() {
        while (fRun) {
            Orders orders = new Orders();
            Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
            ShoppingCart shoppingCart = new ShoppingCart();
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
            synchronized (orders) {
                orders.offer(shoppingCart, credentials);
                orders.show();
            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
