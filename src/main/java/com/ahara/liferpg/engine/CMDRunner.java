package com.ahara.liferpg.engine;

import com.ahara.liferpg.engine.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CMDRunner implements CommandLineRunner {

    @Autowired
    Runner runner;

    @Override
    public void run(String... args) {
//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
////
////        ctx.register(EngineConfiguration.class);
////        ctx.refresh();
        runner.runGame();
////

    }
}
