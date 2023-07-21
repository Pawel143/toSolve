package com.example.carsharing.repository;

import com.example.carsharing.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface customerRepository extends JpaRepository<Customer, Long> {
}
