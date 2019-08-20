package ru.eltex.app.java.lab4;

public class CheckDone extends ACheck {

    CheckDone(Orders orders, long pauseCheck) {
        super(orders);
        this.pauseCheck = pauseCheck;
    }

    @Override
    public void run() {
//        while (fRun) {
            synchronized (getOrders()) {
                System.out.println("--------------------------");
                System.out.println("Статус заказа: БЫЛО " + getOrders().orderStat());
                getOrders().checkDone();
                System.out.println("Статус заказа: СТАЛО " + getOrders().orderStat() + "  Время ожидания заказа: " + getOrders().timeWait() + "    --вызов из checkDone");
//            }
//            try {
//                Thread.sleep(pauseCheck);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
