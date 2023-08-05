package com.example.carsharing.service;


import com.example.carsharing.repository.CarJPA;
import com.example.carsharing.repository.CompanyJPA;
import com.example.carsharing.repository.CustomerJPA;
import com.example.carsharing.repository.entity.Car;
import com.example.carsharing.repository.entity.Company;
import com.example.carsharing.repository.entity.Customer;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@Service
public class CarService {
    private static Long cho;
    Scanner sc = new Scanner(System.in);
    private final CarJPA carRep;

    private final CompanyJPA comRep;

    private final CustomerJPA cusRep;

    @Autowired
    public CarService(@Qualifier("carRepo") CarJPA carRep, @Qualifier("comRepo") CompanyJPA comRep, @Qualifier("cusRepo") CustomerJPA cusRep) {
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


    public void carsList(Long COMPANY_ID) {
        String res = comRep.findNameByID(COMPANY_ID);
        if (COMPANY_ID == 0) {
            menuImp(1);
        }
        if (!(res == null) && res.length() > 0) {
            System.out.println(res + " company");
            System.out.println("""
                    1. Car list
                    2. Create a car
                    0. Back""");

            int in = sc.nextInt();
            switch (in) {
                case 1: {
                    List<Car> carList = carRep.findByCompanyId(COMPANY_ID);
                    int id = 0;

                    if (!(carList.isEmpty())) {

                        System.out.println("\nCar List:");


                        for (Car x : carList) {
                            id++;
                            System.out.println((id) + ". " + x.getCarName());

                        }
                        System.out.println("\n");
                        carsList(COMPANY_ID);


                    } else {
                        System.out.println("The car list is empty!");
                        carsList(COMPANY_ID);
                    }


                    break;
                }
                case 2: {
                    System.out.println("Enter the car name:");
                    sc.nextLine();
                    String carName = sc.nextLine();

                    if (isNumeric(carName)) {
                        System.out.println("The car list is empty!");
                        carsList(COMPANY_ID);
                    }
                    try {
                        carRep.save(new Car(carName, COMPANY_ID));

                    } catch (ConstraintViolationException e) {
                        System.out.println("This car is exist in database");
                    }

                    System.out.println("The car was added!");

                    carsList(COMPANY_ID);

                    break;
                }
                case 0: {
                    menuImp(1);
                }
            }
        } else {
            System.out.println("No company found.");
        }


    }


    public void menuImp(int a) {
        {

            Scanner sc = new Scanner(System.in);


            switch (a) {
                case 1: {
                    System.out.println("""
                            1. Company list
                            2. Create a company
                            0. Back""");
                    switch (sc.nextInt()) {
                        case 1: {
                            printCompanyList();
                            break;

                        }
                        case 2: {

                            System.out.println("Enter the company name:");
                            sc.nextLine();
                            String comName = sc.nextLine();


                            try {
                                comRep.save(new Company(comName));
                            } catch (ConstraintViolationException e) {
                                System.out.println("This company is exist in database");
                            }

                            System.out.println("The company was created!\n");

                            menuImp(1);
                            break;
                        }


                        case 0: {
                            menuImp(start());
                            break;
                        }

                    }
                    break;
                }
                case 2: {
                    printCustomerList(a, 1);
                    break;
                }
                case 3: {

                    System.out.println("Enter the customer name:");

                    String cusName = sc.nextLine();

                    try {
                        cusRep.save(new Customer(cusName, null));
                    } catch (ConstraintViolationException e) {
                        System.out.println("This customer is exist in database");
                    }

                    System.out.println("The customer was created!");
                    System.out.println();

                    menuImp(start());

                    break;
                }
                case 0: {
                    System.exit(0);
                    break;
                }

            }

        }
    }

    public void printCustomerList(long CUSTOMER_ID, int option) {
        List<Customer> customerList = cusRep.findAll();

        Scanner sc = new Scanner(System.in);

        long choice = 0L;
        if (!(customerList.isEmpty())) {
            switch (option) {
                case 1: {

                    System.out.println("Customer list:");

                    int i = 0;
                    for (Customer x : customerList) {

                        i++;
                        System.out.println(x.getID() + ". " + x.getCusName());
                    }
                    System.out.println("0. Back");

                    cho = sc.nextLong();
                    if (cho == 0) {
                        menuImp(start());
                    }
                }
                case 2: {
                    System.out.println("""
                            1. Rent a car
                            2. Return a rented car
                            3. My rented car
                            0. Back""");


                    int op = sc.nextInt();
//                    ArrayList<Integer> objects = new ArrayList<>();
                    switch (op) {
                        case 1: {

                            Integer rentedCarId = cusRep.findRentedCarIdByID(cho);
                            System.out.println();
                            if (rentedCarId == null || rentedCarId == 0) {

                                List<Company> companyList = comRep.findAll();

                                System.out.println("Choose a company::");

                                for (Company x : companyList) {

                                    System.out.println(x.getID() + ". " + x.getComName());
                                }
                                System.out.println("0. Back");

                                choice = sc.nextLong();


                                if (choice > 0) {

                                    List<String> RENTED_CAR_ID = carRep.RENTED_CAR_ID();
                                    List<Car> tSet = carRep.findByCompanyId(choice);


                                    int id = 0;
                                    ArrayList<String> strings = new ArrayList<>();

                                    if (RENTED_CAR_ID.isEmpty()) {

                                        System.out.println("\nChoose a car:");

                                        String name;

                                        for (Car x : tSet) {
                                            name = x.getCarName();
                                            if (!(RENTED_CAR_ID.contains(name))) {
                                                id++;
                                                strings.add(name);
                                                System.out.println((id) + ". " + strings.get(id - 1));
                                            }
                                        }
                                        System.out.println("0. Back");
                                        int rented = sc.nextInt();
                                        if (rented == 0) {
                                            printCustomerList(CUSTOMER_ID, 2);
                                            break;
                                        }

                                        System.out.println("\nYou rented '" + strings.get(rented - 1) + "'");


                                        int carId = carRep.findIdByName(strings.get(rented - 1));
                                        Customer customerUpdate = cusRep.findById(cho).orElse(null);

                                        if (customerUpdate != null) {
                                            customerUpdate.setRentedCarId(carId);
                                            cusRep.save(customerUpdate);
                                        }


                                        printCustomerList(choice, 2);
                                    } else {
                                        System.out.println("The car list is empty!");

                                    }

                                } else {
                                    menuImp(1);
                                }

                            } else {
                                System.out.println("You've already rented a car!");
                                printCustomerList(CUSTOMER_ID, 2);
                            }
                            break;
                        }
                        case 2: {

                            Customer customerToUpdate = cusRep.findById(cho).orElse(null);

                            if (customerToUpdate.getRentedCarId() != null) {

                                customerToUpdate.setRentedCarId(null);

                                cusRep.save(customerToUpdate);

                                System.out.println("You've returned a rented car!\n");
                                printCustomerList(CUSTOMER_ID, 2);
                            } else {

                                System.out.println("You didn't rent a car!\n");
                                printCustomerList(CUSTOMER_ID, 2);
                            }

                            break;

                        }
                        case 3: {
                            rentedCarList(CUSTOMER_ID);
                            break;
                        }
                        case 0: {
                            menuImp(start());
                        }
                    }


                }


            }
        } else {
            System.out.println("The customer list is empty!\n");

            menuImp(start());
        }

    }

    public void printCompanyList() {


        List<Company> companyList = comRep.findAll();


        if (!(companyList.isEmpty())) {
            System.out.println("Choose a company:");

            for (Company x : companyList) {

                System.out.println(x.getID() + ". " + x.getComName());
            }
            System.out.println("0. Back");

            int choice = sc.nextInt();
            if (choice > 0) {
                carsList((long) choice);
            } else {
                menuImp(1);
            }
        } else {
            System.out.println("The company list is empty");
            menuImp(1);
        }

    }


    public int start() {
        System.out.println("1. Log in as a manager");
        System.out.println("2. Log in as a customer");
        System.out.println("3. Create a customer");
        System.out.println("0. Exit");
        return sc.nextInt();
    }


    public void rentedCarList(Long CUSTOMER_ID) {

        String cusName = cusRep.findCusNameByID(cho);
        String re;
        if (cusName != null) {
            re = cusName;
        } else {
            re = "wrong";
            System.out.println("You didn't rent a car!");
        }

        Long renCarId = cusRep.findRentedCarIdByCusName(re);

        if (renCarId == null) {
            System.out.println("You didn't rent a car!\n");
            printCustomerList(CUSTOMER_ID, 2);
            return;
        }


        String carName = carRep.findCarNameByID(renCarId);
        if (carName == null) {
            System.out.println("You didn't rent a car!\n");
            printCustomerList(CUSTOMER_ID, 2);
            return;

        }
        Long com_ID = carRep.findCompanyIdByCarName(carName);
        String companyName = comRep.findNameByID(com_ID);


        if (companyName == null) {
            System.out.println("You didn't rent a car!\n");
            printCustomerList(CUSTOMER_ID, 2);
            return;
        }

        System.out.println("Your rented car:");


        System.out.println(carName);

        System.out.println("Company:");


        System.out.println(companyName + "\n");

        printCustomerList(CUSTOMER_ID, 2);
    }

}
