package com.example.carsharing.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long ID;
    @Column(name = "customer_name")
    private String cusName;
    @Column(name = "RENTED_CAR_ID")
    private Integer rentedCarId;

    public Customer(Long ID, String cusName, Integer rentedCarId) {
        this.ID = ID;
        this.cusName = cusName;
        this.rentedCarId = rentedCarId;
    }
}
