package com.Bo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "MENU_ITEM")
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class MenuItem {
    @Id
    @GeneratedValue
    private int id;

    @JsonIgnore
    @JoinColumn(name = "MENU_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    Menu menu;

    private String name;
    private float price;
    private String description;

    public MenuItem(String name, String description, float price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }
}
