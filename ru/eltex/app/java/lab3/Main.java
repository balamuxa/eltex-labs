package ru.eltex.app.java.lab3;

import ru.eltex.app.java.lab2.Tovar;
import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab2.Credentials;

import java.util.Scanner;

public class Main {

    public static int sc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Credentials credentials = new Credentials("Ivan", "Ivanov", "ivanov", "ivan@m.tu");
        Orders<Order> orders = new Orders();
        ShoppingCart<Tovar> shoppingCart = new ShoppingCart();
        System.out.println("Введите количество товара которое хотите купить: ");
        Tovar.counter = scanner.nextInt();
        Kraska[] kraskas = new Kraska[99];
        for (int i = 0; i < Tovar.counter; i++) {
            kraskas[i] = new Kraska();
            kraskas[i].create();
            shoppingCart.add(kraskas[i]);
        }
        while (true) {
            System.out.println("Меню:\n1. Оформить заказ\n2. Посмотреть статус заказа\n3. Посмотреть заказ" +
                    "\n4. Функция проверки заказов - обход коллекции и удаление всех объектов, время ожидания которых истекло и статус «обработан" +
                    "\n5. Посмотреть корзину\n6. Удаление позиций из корзины\n7. Добавить товары в корзину" +
                    "\n8. Функция поиска объекта по индетификатору в корзине\n0. Выход");
            sc = scanner.nextInt();
            switch (sc) {
                case 1:
                    /*Оформить заказ*/
                    if (orders.orderStat() == null) {
                        orders.offer(shoppingCart, credentials);
                        orders.checkTime();
                        System.out.println("Ваш оформленный заказ:");
                        System.out.println("--------------------------");
                        orders.show();
                    } else {
                        System.out.println("Заказ уже оформлен");
                    }
                    break;
                case 2:
                    /*Статус заказа*/
                    orders.checkTime();
                    System.out.println("Статус заказа: " + orders.orderStat() +
                            "\nВремя ожидания перехода заказа в другое состояние: " +
                            orders.timeWait() / 1000 + " сек");
                    System.out.println("--------------------------");
                    break;
                case 3:
                    /*Просмотр заказа*/
                    orders.checkTime();
                    System.out.println("Ваш оформленный заказ:");
                    System.out.println("--------------------------");
                    orders.show();
                    break;
                case 4:
                    /*Удаление заказа*/
                    orders.checkDone();
                    System.out.println("Теперь посмотрите статус заказа!");
                    System.out.println("-------------------------------");
                    break;
                case 5:
                    /*Просмотр корзины*/
                    System.out.println("Корзина:");
                    System.out.println("--------------------------");
                    shoppingCart.show();
                    break;
                case 6:
                    /*Удаление корзины*/
                    for (int i = 0; i < Tovar.counter; i++) {
                        shoppingCart.delete(kraskas[i]);
                    }
                    Tovar.counter = 0;
                    break;
                case 7:
                    /*Добавление товаров в корзину*/
                    System.out.println("Введите количество товара которое хотите добавить");
                    sc = scanner.nextInt();
                    System.out.println("Такие позиции вы добавили:\n ");
                    for (int i = Tovar.counter; i < Tovar.counter + sc; i++) {
                        kraskas[i] = new Kraska();
                        kraskas[i].create();
                        shoppingCart.add(kraskas[i]);
                        kraskas[i].read();
                        System.out.println("--------------------------");
                    }
                    Tovar.counter += sc;
                    break;
                case 8:
                    /*Поиск в корзине по id*/
                    try {
                        System.out.println("Какой ID выберете?");
                        for (int i = 0; i < Tovar.counter; i++) {
                            System.out.println((i + 1) + ". " + kraskas[i].getUUID());
//                            System.out.println((i + 1) + ". " + instruments[i].getUUID());
//                            System.out.println((i + 1) + ". " + stroymats[i].getUUID());
                        }
                        int idd = scanner.nextInt();
                        shoppingCart.search(kraskas[idd - 1].getUUID(), kraskas[idd - 1].getUUIDs());
                        System.out.println("-------------------------------");
                        kraskas[idd - 1].read();
                        System.out.println("-------------------------------");
                    } catch (NullPointerException e) {
                        System.out.println("-------------------------------");
                        System.out.println("Не существует ID под таким номером!!!");
                        break;
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("-------------------------------");
                    System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                    break;
            }
        }
    }
}
