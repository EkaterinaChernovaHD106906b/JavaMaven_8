package ru.netology.domain;

import lombok.Data;

@Data

public class Smartphone extends Product {

    protected String producer;

    public Smartphone(String producer) {
        this.producer = producer;
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }
}
