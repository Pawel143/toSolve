package com.example.carsharing.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "CAR")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long ID;
    @Column(name = "car_name")
    String carName;
    @Column(name = "company_id")
    Long companyId;


    public Car(String carName, Long companyId) {
        this.carName = carName;
        this.companyId = companyId;
    }
}
