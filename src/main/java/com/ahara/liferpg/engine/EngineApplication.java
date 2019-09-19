package com.ahara.liferpg.engine;

import com.ahara.liferpg.engine.runner.Runner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Console;

@SpringBootApplication
public class EngineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EngineApplication.class, args);
    }

    @Override
    public void run(String... args) {
        (new Runner()).runGame();
    }
}
