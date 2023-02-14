package com.example.transportationservice.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity

public class CustomerOrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderId;
    private LocalDateTime transportTime;
    @OneToOne
    private Customer customer;
    @OneToMany(mappedBy = "customerOrderProduct")
    private List<Product> products;

    public void addProduct(Product product){
        product.setCustomerOrderProduct(this);
        products.add(product);
    }
}
