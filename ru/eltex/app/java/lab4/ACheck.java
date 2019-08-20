package ru.eltex.app.java.lab4;

public abstract class ACheck implements Runnable {

    public volatile boolean fRun = true;
    public long pause = 2000;
    public Orders orders;

    public ACheck(Orders orders) {
        this.orders = orders;
//        orders.show();
    }

    public void offThread() {
//        if (fRun = true) {
            fRun = false;
//        } else {
//            return;
//        }
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


}
