package com.example.carsharing.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name = "COMPANY")
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    Long ID;
    @Column(name = "company_name")
    String comName;

    public Company(String comName) {
        this.comName = comName;
    }
}
