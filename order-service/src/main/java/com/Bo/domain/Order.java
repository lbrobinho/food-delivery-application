package com.Bo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

    @Id
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
