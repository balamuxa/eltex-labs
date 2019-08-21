package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab4.Orders;

import java.io.*;

public class ManagerOrderFile extends AManageOrder {

    public static final String OrdersFile = "/home/balamuxa/IdeaProjects/eltex-labs3/orders.txt";

    public ManagerOrderFile() {
        super();
    }


    @Override
    public void readById() {

    }

    @Override
    public void saveById() {

    }

    @Override
    public Orders readAll() {
//        Orders ordersRead = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Orders ordersRead = (Orders) objectInputStream.readObject();
            ordersRead.show();
//            System.out.println(ordersRead);
//            return ordersRead;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveAll(Orders orders) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file))) {
            objectOutputStream.writeObject(orders);
//            objectOutputStream.flush();
//            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
