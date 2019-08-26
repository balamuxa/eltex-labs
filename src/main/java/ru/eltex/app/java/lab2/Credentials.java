package ru.eltex.app.java.lab2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.UUID;

public class Credentials implements Serializable {

    @SerializedName("ID покупателя")
    private UUID id;
    @SerializedName("Фамилия")
    private String name;
    @SerializedName("Имя")
    private String firstName;
    @SerializedName("Отчество")
    private String secondName;
    @SerializedName("Электронная почта")
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