package com.example.son.SpringMVC.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyStartupRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("App đã khởi động xong, thực hiện logic ở đây...");
    }
}
