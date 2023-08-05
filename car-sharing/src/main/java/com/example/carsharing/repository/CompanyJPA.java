package com.example.carsharing.repository;

import com.example.carsharing.repository.entity.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("comRepo")
@Repository
public interface CompanyJPA extends JpaRepository<Company, Long> {

    @Query("SELECT c.comName FROM Company c WHERE c.id = :id")
    String findNameByID(Long id);


    List<Company> findAll();
}
