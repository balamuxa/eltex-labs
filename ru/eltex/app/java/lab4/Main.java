package ru.eltex.app.java.lab4;

import ru.eltex.app.java.lab3.Order;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Orders<Order> orders = new Orders();
        Generator gen = new Generator(orders);
        CheckTime checkTime = new CheckTime(orders, 1000);
        CheckDone checkDone = new CheckDone(orders, 1000);

        /*Запуск первого потока*/
        Thread generator1 = new Thread(gen, "Поток 1");
        generator1.start();
        System.out.println("\n" + generator1.getName() + "\n");
        generator1.join(500);

        /*Запуск и остановка потока проверки статуса заказа в состоянии WAIT*/
        Thread checkTimeThread = new Thread(checkTime);
        checkTimeThread.start();
        checkTimeThread.join(500);
        checkTime.offThread();

        /*Запуск и остановка потока проверки статуса заказа в состоянии DONE*/
        Thread checkDoneThread = new Thread(checkDone);
        checkDoneThread.start();
        checkDoneThread.join(500);
        checkDone.offThread();

        /*Запуск второго потока*/
        Thread generator2 = new Thread(gen, "Поток 2");
        generator2.start();
        System.out.println("\n" + generator2.getName() + "\n");
        generator2.join(500);

        /*Запуск и остановка потока проверки статуса заказа в состоянии WAIT*/
        checkTime.onThread();
        Thread checkTime2 = new Thread(checkTime);
        checkTime2.start();
        checkTime2.join(500);
        checkTime.offThread();

        /*Запуск и остановка потока проверки статуса заказа в состоянии DONE*/
        checkDone.onThread();
        Thread checkDone2 = new Thread(checkDone);
        checkDone2.start();
        checkDone2.join(500);
        checkDone.offThread();

        /*Остановка первого и второго потоков*/
        gen.offThread();


        /*Ввод с консоли*/
        /*Запуск потока*/
//        Scanner scanner = new Scanner(System.in);
//        int sc;
//        while (true) {
//            Thread.sleep(100);
//            System.out.println("Меню:\n1.Генерация заказа\n2.Работа класса CheckTime\n3.Работа класса CheckDone" +
//                    "\n0.Выход");
//            sc = scanner.nextInt();
//            switch (sc) {
//                case 1:
//                    Thread generator = new Thread(gen, "Поток");
//                    generator.start();
//                    System.out.println("\n" + generator.getName() + "\n");
//                    break;
//                case 2:
//                    Thread checkTimeThread = new Thread(checkTime);
//                    checkTimeThread.start();
//                    break;
//                case 3:
//                    Thread checkDoneThread = new Thread(checkDone);
//                    checkDoneThread.start();
//                    break;
//                case 0:
//                    return;
//                default:
//                    System.out.println("Неправильный ввод");
//            }
//        }
    }
}
