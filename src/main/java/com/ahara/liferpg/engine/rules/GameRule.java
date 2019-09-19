package com.ahara.liferpg.engine.rules;

import com.ahara.liferpg.engine.gameObjects.GameObject;

public interface GameRule {
    public void applyTo(GameObject g);
}
