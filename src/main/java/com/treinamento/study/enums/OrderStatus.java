package com.treinamento.study.enums;

public enum OrderStatus {

    WAITNG_PAYMENT(1),
    PAID(2),
    PACKING(3),
    SHIPED(4),
    DELIVERED(5),
    CANCELED(6);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return  code;
    }

    public static OrderStatus valueOf(int code){
        for(OrderStatus value : OrderStatus.values()){
            if (value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Ivalid OrderStatus code");
    }
}
