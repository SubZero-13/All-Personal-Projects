package com.enums;

public enum CarType {
    HATCHBACK("Hatchback", 0.05),
    SEDAN("Sedan", 0.08),
    SUV("SUV", 0.10);

    private final double premiumRate;
    private final String carType;

    CarType(String carType, double premiumRate) {
        this.premiumRate = premiumRate;
        this.carType = carType;
    }

    public double getPremiumRate() {
        return premiumRate;
    }
    
    @Override
    public String toString() {
        return carType;
    }
}
