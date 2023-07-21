package com.example.carsharing;

//import com.example.carsharing.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;
@EnableJpaRepositories(basePackages = "com.example.carsharing.repository")
@EntityScan(basePackages = "com.example.carsharing.repository.entity")
@SpringBootApplication
public class Main implements CommandLineRunner {
   // CarService service;

    @Autowired
    //public Main(CarService service) {
     //   this.service = service;
   // }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }


    @Override
    public void run(String... args) {
        System.out.println("ASASS");
    }
//
//
//        try (Scanner sc = new Scanner(System.in)) {
//            wh:  // while (true) {
//                System.out.println("1. Log in as a manager");
//                System.out.println("2. Log in as a customer");
//                System.out.println("3. Create a customer");
//                System.out.println("0. Exit");
//                int op1 = sc.nextInt();
//               switch (op1) {
//                       case 1: {
//                        System.out.println(" 1. Company list \n2. Create a company \n0. Back");
//                           cs1: switch (sc.nextInt()) {
//                               case 1: {
//                                service.CompanyList();
//                                int choice = sc.nextInt();
//                                if (choice > 0) {
//                                  //  carsList(con, choice);
//                                } else {
//                                    op1 = 1;
//                                  break;
//                                }
//                                break;
//
//                            }
//                            case 2: {
//
//
//                            }
//
//
//                            case 0: {
//                               main(args);
//                            }
//
//                        }
//                        break;
//                    }
//
//                }
//            }
//
//
//        }
   // }


}
