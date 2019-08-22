package ru.eltex.app.java.lab2;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public abstract class Tovar implements ICrudAction, Serializable {

    UUID ID;
    public static HashSet<UUID> setId = new HashSet<>();
    public static int counter = 0;
    protected String name;
    protected int article;
    protected int price;
    protected String developer;

    @Override
    public void create() {
        Random random = new Random();
        this.ID = UUID.randomUUID();
        this.setId.add(ID);
        this.article = random.nextInt(1000000);
        this.price = random.nextInt(5000);
//        counter++;
    }

    @Override
    public void read() {
        System.out.println("ID товара:" + this.ID);
        System.out.println("Название:" + this.name);
        System.out.println("Артикул: " + this.article);
        System.out.println("Цена:" + this.price);
        System.out.println("Производитель:" + this.developer);
//        System.out.println("+++++++++++++++++++++++++++++++++");
//        System.out.println("Количество товаров: " + counter);
//        System.out.println("---------------------------------");
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите артикул: ");
        this.article = scanner.nextInt();
        System.out.println("Введите цену: ");
        this.price = scanner.nextInt();
    }

    @Override
    public void delete() {
        this.ID = null;
        this.article = 0;
        this.price = 0;
        counter--;
    }

    public UUID getUUID() {
        return ID;
    }

    public HashSet<UUID> getUUIDs() {
        return setId;
    }
}
