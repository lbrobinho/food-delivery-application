package com.Bo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    private String id;

    private List<MenuItem> menuItems;

    private UserInfo userInfo;

    private String restaurantId;
    private String specialNote;
    private int totalPrice;
    private long orderTime;
    private long deliveryTime;
    private String paymentId;

    public UserInfo getUserInfo(){return userInfo; }
}
