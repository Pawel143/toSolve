package com.example.carsharing.repository;

import com.example.carsharing.repository.entity.Customer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("cusRepo")
@Repository
public interface CustomerJPA extends JpaRepository<Customer, Long> {
    List<Customer> findAll();

    @Query("SELECT c.cusName FROM Customer c WHERE c.id = :id")
    String findCusNameByID(Long id);

    @Query("SELECT c.rentedCarId FROM Customer c WHERE c.id = :customerId")
    Integer findRentedCarIdByID(Long customerId);

    @Query("SELECT c.rentedCarId FROM Customer c WHERE c.cusName = :name")
    Long findRentedCarIdByCusName(String name);

}
