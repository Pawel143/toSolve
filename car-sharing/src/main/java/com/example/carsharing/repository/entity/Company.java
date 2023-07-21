package com.example.carsharing.repository.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;

import javax.persistence.*;

@Entity
@Data
@Table(name = "COMPANY")
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long ID;
    @Column(name = "company_name")
    private String comName;

    public Company(long ID, String comName) {
        this.ID = ID;
        this.comName = comName;
    }
}
