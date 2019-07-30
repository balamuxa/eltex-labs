package ru.eltex.app.java.lab1;

import java.util.Scanner;

public class Main {
    public static final String kraska = "kraska";
    public static final String instruments = "instruments";
    public static final String stroymat = "stroymat";
    public static int cases;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        if (args[0].equals(kraska)) {

            /*      Проверка работы перегрузки конструктора     */
//            Kraska kraska = new Kraska("Green", 100023, 12323, "Russia");
//            kraska.read();

            System.out.println("Введите количество товара: ");
            Tovar.counter = scanner.nextInt();
            Kraska[] kraskas = new Kraska[99];
            while (true) {
                System.out.println("\nВыберите действие:" +
                        "\n1-заполнение объекта случайными значениями и инкремент счётчика" +
                        "\n2-вывод данных на экран" +
                        "\n3-ввод данных с клавиатуры" +
                        "\n4-принудительное зануление данных в объекте и декремент счетчика" +
                        "\n0-Выход");
                cases = scanner.nextInt();
                switch (cases) {
                    case 1:
                        if (Tovar.counter == 0) {
                            System.out.println("Введите количество товара: ");
                            Tovar.counter = scanner.nextInt();
                            for (int i = 0; i < Tovar.counter; i++) {
                                kraskas[i] = new Kraska();
                                kraskas[i].create();
                            }
                        } else {
                            for (int i = 0; i < Tovar.counter; i++) {
                                kraskas[i] = new Kraska();
                                kraskas[i].create();
                            }
                        }
                        break;
                    case 2:
                        try {
                            if (Tovar.counter == 0) {
                                System.out.println("Нет данных");
                            } else {
                                for (int i = 0; i < Tovar.counter; i++) {
                                    kraskas[i].read();
                                    System.out.println("---------------------------------");
                                }
                                System.out.println("Количество товаров: " + Tovar.counter);
                                System.out.println("---------------------------------");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Объект пустой, сначала нужно заполнить его значениями!!!");
                        }
                        break;
                    case 3:
                        kraskas[Tovar.counter] = new Kraska();
                        kraskas[Tovar.counter].update();
                        System.out.println("Введенные данные:");
                        kraskas[Tovar.counter].read();
                        Tovar.counter++;
                        System.out.println("---------------------------------");
                        System.out.println("Количество товаров: " + Tovar.counter);
                        System.out.println("---------------------------------");
                        break;
                    case 4:
                        for (int i = 0; i < Tovar.counter; i++) {
                            kraskas[i].delete();
                        }
                        Tovar.counter = 0;
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                        break;
                }
            }
        } else if (args[0].equals(instruments)) {

            /*      Проверка работы перегрузки конструктора     */
//            Instruments instruments = new Instruments("Топор", 100023, 12323, "Russia");
//            instruments.read();

            System.out.println("Введите количество товара: ");
            Tovar.counter = scanner.nextInt();
            Instruments[] instruments = new Instruments[99];
            while (true) {
                System.out.println("\nВыберите действие:" +
                        "\n1-заполнение объекта случайными значениями и инкремент счётчика" +
                        "\n2-вывод данных на экран" +
                        "\n3-ввод данных с клавиатуры" +
                        "\n4-принудительное зануление данных в объекте и декремент счетчика" +
                        "\n0-Выход");
                cases = scanner.nextInt();
                switch (cases) {
                    case 1:
                        if (Tovar.counter == 0) {
                            System.out.println("Введите количество товара: ");
                            Tovar.counter = scanner.nextInt();
                            for (int i = 0; i < Tovar.counter; i++) {
                                instruments[i] = new Instruments();
                                instruments[i].create();
                            }
                        } else {
                            for (int i = 0; i < Tovar.counter; i++) {
                                instruments[i] = new Instruments();
                                instruments[i].create();
                            }
                        }
                        break;
                    case 2:
                        try {
                            if (Tovar.counter == 0) {
                                System.out.println("Нет данных в объекте!!");
                            } else {
                                for (int i = 0; i < Tovar.counter; i++) {
                                    instruments[i].read();
                                    System.out.println("---------------------------------");
                                }
                                System.out.println("Количество товаров: " + Tovar.counter);
                                System.out.println("---------------------------------");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Объект пустой, сначала нужно заполнить его значениями!!!");
                        }
                        break;
                    case 3:
                        instruments[Tovar.counter] = new Instruments();
                        instruments[Tovar.counter].update();
                        System.out.println("Введенные данные:");
                        instruments[Tovar.counter].read();
                        Tovar.counter++;
                        System.out.println("---------------------------------");
                        System.out.println("Количество товаров: " + Tovar.counter);
                        System.out.println("---------------------------------");
                        break;
                    case 4:
                        for (int i = 0; i < Tovar.counter; i++) {
                            instruments[i].delete();
                        }
                        Tovar.counter = 0;
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                        break;
                }
            }
        } else if (args[0].equals(stroymat)) {

            /*      Проверка работы перегрузки конструктора     */
//            Stroymat stroymat = new Stroymat("Фанера", 100023, 12323, "Russia");
//            stroymat.read();

            System.out.println("Введите количество товара: ");
            Tovar.counter = scanner.nextInt();
            Stroymat[] stroymats = new Stroymat[99];
            while (true) {
                System.out.println("\nВыберите действие:" +
                        "\n1-заполнение объекта случайными значениями и инкремент счётчика" +
                        "\n2-вывод данных на экран" +
                        "\n3-ввод данных с клавиатуры" +
                        "\n4-принудительное зануление данных в объекте и декремент счетчика" +
                        "\n0-Выход");
                cases = scanner.nextInt();
                switch (cases) {
                    case 1:
                        if (Tovar.counter == 0) {
                            System.out.println("Введите количество товара: ");
                            Tovar.counter = scanner.nextInt();
                            for (int i = 0; i < Tovar.counter; i++) {
                                stroymats[i] = new Stroymat();
                                stroymats[i].create();
                            }
                        } else {
                            for (int i = 0; i < Tovar.counter; i++) {
                                stroymats[i] = new Stroymat();
                                stroymats[i].create();
                            }
                        }
                        break;
                    case 2:
                        try {
                            if (Tovar.counter == 0) {
                                System.out.println("Нет данных в объекте!!");
                            } else {
                                for (int i = 0; i < Tovar.counter; i++) {
                                    stroymats[i].read();
                                    System.out.println("---------------------------------");
                                }
                                System.out.println("Количество товаров: " + Tovar.counter);
                                System.out.println("---------------------------------");
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Объект пустой, сначала нужно заполнить его значениями!!!");
                        }
                        break;
                    case 3:
                        stroymats[Tovar.counter] = new Stroymat();
                        stroymats[Tovar.counter].update();
                        System.out.println("Введенные данные:");
                        stroymats[Tovar.counter].read();
                        Tovar.counter++;
                        System.out.println("---------------------------------");
                        System.out.println("Количество товаров: " + Tovar.counter);
                        System.out.println("---------------------------------");
                        break;
                    case 4:
                        for (int i = 0; i < Tovar.counter; i++) {
                            stroymats[i].delete();
                        }
                        Tovar.counter = 0;
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Неправильный ввод: повторите ввод значения ещё раз");
                        break;
                }
            }
        } else {
            System.out.println("Ошибка: неправильно введеный вид представления");
            return;
        }
    }
}




