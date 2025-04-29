package com.estudos.course.Enums;

import lombok.Getter;

@Getter
public enum OrderStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private final Integer code;

    OrderStatus(Integer number) {
        this.code = number;
    }

    public static OrderStatus valueOf(Integer code) {
        for (OrderStatus value : OrderStatus.values()) {
            if(value.getCode().equals(code)) {
                return value;
            }
        }
       throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
