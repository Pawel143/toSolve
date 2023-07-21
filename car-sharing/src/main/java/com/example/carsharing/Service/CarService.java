package com.example.carsharing.Service;

import com.example.carsharing.repository.carRepository;
import com.example.carsharing.repository.companyJPA;
import com.example.carsharing.repository.customerRepository;
import com.example.carsharing.repository.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class CarService {

   private final carRepository carRep;

   private final companyJPA comRep;

    private final customerRepository cusRep;

    @Autowired
    public CarService(carRepository carRep, companyJPA comRep, customerRepository cusRep) {
        this.carRep = carRep;
        this.comRep = comRep;
        this.cusRep = cusRep;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void CompanyList() {
        List<Company> com = comRep.findAllCompanyName();
        if (com.isEmpty()) {
            for (Company x : com) {
                System.out.println(x.getID() + ". " + x.getComName());
            }
            System.out.println("0. Back");
        }{
            System.out.println("The company list is empty");
        }
    }
}
