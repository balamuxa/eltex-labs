package ru.eltex.app.java.lab3;

import ru.eltex.app.java.lab2.Kraska;
import ru.eltex.app.java.lab2.Tovar;

import java.util.*;

public class ShoppingCart<T extends Tovar> {

    private List<T> tovars;
    public Set<UUID> uuids;

    public ShoppingCart() {
        this.tovars = new ArrayList<>();
        this.uuids = new TreeSet<>();
    }

    public ShoppingCart(List<T> tovars) {
        this.tovars = tovars;
    }

    public boolean add(T tovar) {
        uuids.add(tovar.getUUID());
        return tovars.add(tovar);
    }

    public void delete(T tovar) {
        uuids.remove(tovar.getUUID());
        tovars.remove(tovar);
    }

    public void show() {
        for (Tovar tovar : tovars) {
            tovar.read();
            System.out.println("-------------------------");
        }
    }

    public void show(UUID id, Kraska kraskas) {
        if (isExistsUUID(id))
            kraskas.read();
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
