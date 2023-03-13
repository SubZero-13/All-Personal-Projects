package com.enums;

public enum InsuranceType {
    BASIC("Basic"), PREMIUM("Premium");

    private final String value;

    private InsuranceType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
