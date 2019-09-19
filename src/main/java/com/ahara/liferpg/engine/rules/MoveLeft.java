package com.ahara.liferpg.engine.rules;

import com.ahara.liferpg.engine.gameObjects.GameObject;
import com.ahara.liferpg.engine.gameObjects.Moveable;

public class MoveLeft implements GameRule {

    @Override
    public void applyTo(GameObject g) {
        if (g instanceof Moveable) {
            ((Moveable)g).move(g.x() - 1, g.y());
        }
    }
}
