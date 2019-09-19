package com.ahara.liferpg.engine.runner;


import com.ahara.liferpg.engine.gameObjects.World;
import com.ahara.liferpg.engine.rules.GameRule;

import java.util.ArrayList;

public class Runner {
    private static Integer STEP_LENGTH = 10;

    private World _w;
    private ArrayList<GameRule> _r;

    public Runner() {
        _w = WorldInitalizer.initializeWorld();
        _r = RuleInitializer.initializeRules();
    }

    public void runGame() {
        int turn = 0;

        while (true) {
            try
            {
                Long begin = System.currentTimeMillis();

                doTurn();

                turn += 1;
                System.out.println(String.format("Completed turn %d.", turn));
                long sleep = (begin + STEP_LENGTH) - System.currentTimeMillis();
                if (sleep < 0) {
                    sleep = 0L;
                }
                Thread.sleep(sleep);
            }
            catch (Exception e) {

            }
        }
    }

    private void doTurn() {
        //Accept Input
        //Run Pieces
        _w.allObjects().forEach((g) -> _r.forEach((r) -> r.applyTo(g)));
        //Garbage Collect
        //Save Board State
        //Print BoardState
    }
}
