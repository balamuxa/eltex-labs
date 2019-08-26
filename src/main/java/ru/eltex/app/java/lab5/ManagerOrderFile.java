package ru.eltex.app.java.lab5;

import ru.eltex.app.java.lab3.Order;
import ru.eltex.app.java.lab4.Orders;

import java.io.*;
import java.util.HashSet;
import java.util.UUID;

public class ManagerOrderFile extends AManageOrder {

    @Override
    public Order readById(HashSet<UUID> uuid) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file1))) {
            Order orderRead = (Order) objectInputStream.readObject();
            if (orderRead.getSetId().equals(uuid))
                orderRead.show();
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
    public void saveById(Order order) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(file1))) {
            objectOutputStream.writeObject(order);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Orders readAll() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file1))) {
            Orders ordersRead = (Orders) objectInputStream.readObject();
            ordersRead.show();
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
                new FileOutputStream(file1))) {
            objectOutputStream.writeObject(orders);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
