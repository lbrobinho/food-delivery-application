package com.Bo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@NoArgsConstructor
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue
    private int restaurantId;

    private String name;

    @OneToMany(mappedBy = "restaurant")
    private List<Menu> menus = new ArrayList<>();

    private long phoneNumber;
    private String address;

    @JsonCreator // Convert Json String to this class
    public Restaurant (@JsonProperty("name") String name,
                       @JsonProperty("phone number") String phoneNumber,
                       @JsonProperty("address") String address) {
        this.name = name;
        this.phoneNumber = Long.parseLong(phoneNumber);
        this.address = address;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }
}
