package ru.eltex.app.java.lab1;

import java.util.Scanner;
import java.util.UUID;

public class Instruments extends Tovar {


    Instruments(){
        ID = UUID.randomUUID();
        counter++;
        this.name = "";
        this.article = 0;
        this.price = 0;
        this.developer = "";
    }

    Instruments(String name, int article, int price, String developer) {
//        this.ID = id;
        this.name = name;
        this.article = article;
        this.price = price;
        this.developer = developer;
        counter++;
    }
    @Override
    public void create() {
        super.create();
        Rand rand = new Rand();
        this.name = String.valueOf(rand.TovarInstrumentsName());
        this.developer = String.valueOf(rand.TovarInstrumentsDeveloper());
    }

    @Override
    public void read() {
        super.read();
    }

    @Override
    public void update() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название инструмента: ");
        this.name = scanner.nextLine();
        super.update();
        System.out.println("Введите производителя инструмента: ");
        this.developer = scanner.nextLine();
    }

    @Override
    public void delete() {
        super.delete();
        this.name = "";
        this.developer = "";
    }
}
