package ru.eltex.app.java.lab4;

public abstract class ACheck implements Runnable {

    public volatile boolean fRun = true;
    public long pauseGen = 10000;
    public long pauseCheck = 100;
    public Orders orders;

    public ACheck(Orders orders) {
        this.orders = orders;
    }

    public void offThread() {
        fRun = false;
    }

    public void onThread() {
        fRun = true;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


}
