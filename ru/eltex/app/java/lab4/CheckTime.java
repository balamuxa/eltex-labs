package ru.eltex.app.java.lab4;

public class CheckTime extends ACheck {

    CheckTime(Orders orders, long pauseCheck) {
        super(orders);
        this.pauseCheck = pauseCheck;
    }

    @Override
    public void run() {
        while (fRun) {
            synchronized (getOrders()) {
                System.out.println("--------------------------");
                System.out.println("Статус заказа: БЫЛО " + getOrders().orderStat());
                getOrders().checkTime();
                System.out.println("Статус заказа: СТАЛО " + getOrders().orderStat() + "    --вызов из checkTime");
            }
            fRun = false;
            try {
                Thread.sleep(pauseCheck);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
