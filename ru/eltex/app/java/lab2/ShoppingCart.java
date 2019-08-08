package ru.eltex.app.java.lab2;

import java.util.*;

public class ShoppingCart {

    private List<Tovar> tovars;
    private Set<UUID> uuids;

    public ShoppingCart() {
        this.tovars = new ArrayList<>();
        this.uuids = new TreeSet<>();
    }

    public ShoppingCart(List<Tovar> tovars) {
        this.tovars = tovars;
    }

    public boolean add(Tovar tovar) {
        uuids.add(tovar.getUUID());
        return tovars.add(tovar);
    }

    void delete(Tovar tovar) {
        this.tovars.remove(tovar);
    }

    public void show() {
        for (Tovar tovar : tovars) {
            tovar.read();
            System.out.println("-------------------------");
        }
    }

    public boolean isExistsUUID(UUID id) {
        return uuids.contains(id);
    }

    public UUID search(UUID uuid, HashSet<UUID> id) {
        if (id.contains(uuid)) {
            for (UUID idd : id) {
                if (idd.equals(uuid))
                    return idd;
            }
            return null;
        }
        return null;
    }
}
