package com.controledeponto.application.enums;

public enum TypeRecord {
    ENTRADA(0),

    SAIDA(1);

    private int code;
    private TypeRecord(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TypeRecord valueOf(int code) {
        for (TypeRecord value : TypeRecord.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Order Status code!");
    }
}
