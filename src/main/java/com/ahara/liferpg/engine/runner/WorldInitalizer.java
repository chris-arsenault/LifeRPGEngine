package com.ahara.liferpg.engine.runner;

import com.ahara.liferpg.engine.gameObjects.Unit;
import com.ahara.liferpg.engine.gameObjects.World;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class WorldInitalizer {

    public static World initializeWorld() {
        World w = new World();
        for (int i = 0; i < 10; i++) {
            w.addObject(new Unit(w), Integer.parseInt(RandomStringUtils.randomNumeric(3)), Integer.parseInt(RandomStringUtils.randomNumeric(3)));
        }

        return w;
    }
}
