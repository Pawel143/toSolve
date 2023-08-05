package com.example.carsharing;


import com.example.carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main implements CommandLineRunner {
    CarService service;
    public static ConfigurableApplicationContext context;

    @Autowired
    public Main(CarService service) {
        this.service = service;
    }

    public static void main(String[] args) {

        context = SpringApplication.run(Main.class, args);
    }


    @Override
    public void run(String... args) {
        service.menuImp(service.start());
    }
}


