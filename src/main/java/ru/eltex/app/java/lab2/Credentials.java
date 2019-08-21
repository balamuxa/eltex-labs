package ru.eltex.app.java.lab2;

import java.util.UUID;

public class Credentials {

    private UUID id;
    private String name;
    private String firstName;
    private String secondName;
    private String eMail;

    public Credentials(String name, String firstName, String secondName, String eMail) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.firstName = firstName;
        this.secondName = secondName;
        this.eMail = eMail;
    }

    public void show() {
        System.out.println("Ваш ID=" + id);
        System.out.println("Имя=" + name);
        System.out.println("Фамилия=" + firstName);
        System.out.println("Отчество=" + secondName);
        System.out.println("email=" + eMail);
    }
}