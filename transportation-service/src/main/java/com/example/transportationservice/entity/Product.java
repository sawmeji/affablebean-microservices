package com.example.transportationservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*
* name
* quantity
* price
* totalAmount
* userEmail
* userName
* userId
* LocalDateTime
* orderId
* */
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    @ManyToOne
    private CustomerOrderProduct customerOrderProduct;


}
