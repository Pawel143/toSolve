package com.example.carsharing.repository.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long ID;
    @Column(name = "car_name")
    private String carName;
    @Column(name = "company_id")
    private Long companyId;



    public Car(long ID, String carName, long companyId) {
        this.ID = ID;
        this.carName = carName;
        this.companyId = companyId;
    }
}
