package ru.eltex.app.java.lab2;

import ru.eltex.app.java.lab2.EnumValue.*;

import java.util.Random;

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
