package com.ilzf.starter.event;

import org.springframework.boot.CommandLineRunner;

public class IlzfCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----CommandLineRunner-----");
    }
}
