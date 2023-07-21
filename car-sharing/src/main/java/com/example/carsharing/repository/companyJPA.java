package com.example.carsharing.repository;

import com.example.carsharing.repository.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface companyJPA extends JpaRepository<Company, Long> {
@Query("SELECT c FROM Company c")
List<Company> findAllCompanyName();


}
