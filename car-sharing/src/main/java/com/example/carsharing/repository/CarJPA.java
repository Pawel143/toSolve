package com.example.carsharing.repository;

import com.example.carsharing.repository.entity.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Qualifier("carRepo")
@Repository
public interface CarJPA extends JpaRepository<Car, Long> {

    @Query("SELECT c.carName FROM Car c WHERE c.ID IN (SELECT cu.rentedCarId FROM Customer cu WHERE cu.rentedCarId > 0)")
    List<String> RENTED_CAR_ID();

    List<Car> findByCompanyId(Long companyId);


    @Query("SELECT c.ID FROM Car c WHERE c.carName = :name")
    Integer findIdByName(String name);

    @Query("SELECT c.carName FROM Car c WHERE c.ID = :renCarId")
    String findCarNameByID(Long renCarId);

    @Query("SELECT c.companyId FROM Car c WHERE c.carName = :carName")
    Long findCompanyIdByCarName(String carName);
}
