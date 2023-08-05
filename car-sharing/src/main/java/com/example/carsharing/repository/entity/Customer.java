package com.example.carsharing.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;
    @Column(name = "CUSTOMER_NAME")
    private String cusName;
    @Column(name = "RENTED_CAR_ID")
    @Nullable
    private Integer rentedCarId;

    public Customer(String cusName, @Nullable Integer rentedCarId) {
        this.cusName = cusName;
        this.rentedCarId = rentedCarId;
    }
}
