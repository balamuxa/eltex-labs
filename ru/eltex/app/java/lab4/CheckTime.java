package ru.eltex.app.java.lab4;

public class CheckTime extends ACheck {

    CheckTime(Orders orders, long pause) {
        super(orders);
        this.pause = pause;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (orders) {//getOrders()) {
//                getOrders().checkTime();
                orders.checkTime();

            }
            try {
                Thread.sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
