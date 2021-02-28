package com.koc.finans.city.score.service.enums;

public enum CityCode {
    i01(1, "Adana"),
    i07(2, "Antalya"),
    i34(3, "İstanbul"),
    i06(4, "Ankara"),
    i35(5, "İzmir"),
    i16(7, "Bursa"),
    i46(6, "Kahramanmaraş"),
    i57(7, "Sinop"),
    i52(8, "Ordu");

    private final Integer value;
    private final String name;

    CityCode(final Integer value, final String name) {
        this.value = value;
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() { return name;}

}

