package ru.eltex.app.java.lab2;

import java.util.Scanner;

public class Main {

    public static int sc;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
        Orders orders = new Orders();
        ShoppingCart shoppingCart = new ShoppingCart();
        System.out.println("Введите количество товара которое хотите купить: ");
        Tovar.counter = scanner.nextInt();
        Kraska[] kraskas = new Kraska[99];
        for (int i = 0; i < Tovar.counter; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart.add(kraskas[i]);
        }
        System.out.println("Оформить заказ?\n1. Да\n2. Нет\n0. Выход");
        sc = scanner.nextInt();
        switch (sc) {
            case 1:
                orders.offer(shoppingCart, credentials);
                orders.checkTime();
                System.out.println("Ваш заказ:");
                System.out.println("--------------------------");
                orders.show();
                break;
            case 2:
                while (true) {
                    System.out.println("Выберите действие:" +
                            "\n1. Посмотреть статус заказа" +
                            "\n2. Оформить заказ" +
                            "\n3. Функция поиска объекта по индетификатору" +
                            "\n4. Функция проверки заказов - обход коллекции и удаление всех объектов," +
                            " время ожидания которых истекло и статус «обработан»" +
                            "\n0. Выход");
                    sc = scanner.nextInt();
                    switch (sc) {
                        case 1:
                            orders.checkTime();
                            System.out.println("Статус заказа: " + orders.orderStat() +
                                    "\nВремя ожидания перехода заказа в другое состояние: " +
                                    orders.timeWait() / 1000 + " сек");
                            System.out.println("--------------------------");
                            break;
                        case 2:
                            if (orders.orderStat() == null) {
                                orders.offer(shoppingCart, credentials);
                                orders.checkTime();
                                System.out.println("Ваш заказ:");
                                System.out.println("--------------------------");
                                orders.show();
                            } else {
                                System.out.println("Заказ уже оформлен");
                            }
                            break;
                        case 3:
                            /*Поиск в корзине по id*/
                            try {
                                System.out.println("Какой ID выберете?");
                                for (int i = 0; i < Tovar.counter; i++) {
                                    System.out.println((i + 1) + ":" + kraskas[i].getUUID());
                                }
                                int idd = scanner.nextInt();
                                shoppingCart.search(kraskas[idd - 1].getUUID(), kraskas[idd - 1].ser());
                                System.out.println("-------------------------------");
                                kraskas[idd - 1].read();
                            } catch (NullPointerException e) {
                                System.out.println("-------------------------------");
                                System.out.println("Не существует ID под таким номером!!!");
                                break;
                            }
                        case 4:
                            orders.checkDone();
                            break;
                        case 0:
                            return;
                        default:
                            System.out.println("-------------------------------");
                            System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                            break;
                    }
                }
            case 0:
                return;
            default:
                System.out.println("-------------------------------");
                System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                break;
        }
    }
}

