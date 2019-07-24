package ru.eltex.app.java.lab1;

import java.util.Random;

import ru.eltex.app.java.lab1.EnumValue.EnumKraskaName;
import ru.eltex.app.java.lab1.EnumValue.EnumKraskaDeveloper;
import ru.eltex.app.java.lab1.EnumValue.EnumInstrumentsName;
import ru.eltex.app.java.lab1.EnumValue.EnumInstrumentsDeveloper;
import ru.eltex.app.java.lab1.EnumValue.EnumStroymatName;
import ru.eltex.app.java.lab1.EnumValue.EnumStroymatDeveloper;

public class Rand {

    EnumKraskaName TovarKraskaName() {
        Random TKN = new Random();
        return EnumKraskaName.values()[TKN.nextInt(EnumKraskaName.values().length)];
    }

    EnumKraskaDeveloper TovarKraskaDeveloper() {
        Random TKD = new Random();
        return EnumKraskaDeveloper.values()[TKD.nextInt(EnumKraskaDeveloper.values().length)];
    }

    EnumInstrumentsName TovarInstrumentsName() {
        Random TIN = new Random();
        return EnumInstrumentsName.values()[TIN.nextInt(EnumInstrumentsName.values().length)];
    }

    EnumInstrumentsDeveloper TovarInstrumentsDeveloper() {
        Random TID = new Random();
        return EnumInstrumentsDeveloper.values()[TID.nextInt(EnumInstrumentsDeveloper.values().length)];
    }

    EnumStroymatName TovarStroymatName() {
        Random TSN = new Random();
        return EnumStroymatName.values()[TSN.nextInt(EnumStroymatName.values().length)];
    }

    EnumStroymatDeveloper TovarStroymatDeveloper() {
        Random TSD = new Random();
        return EnumStroymatDeveloper.values()[TSD.nextInt(EnumStroymatDeveloper.values().length)];
    }
}
