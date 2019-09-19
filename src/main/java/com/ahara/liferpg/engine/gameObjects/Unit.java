package com.ahara.liferpg.engine.gameObjects;
import org.apache.commons.lang3.RandomStringUtils;

public class Unit extends GameObject implements Moveable {
    private World _world;
    private String _role;
    private int _xp;

    public Unit(World w) {
        super(0,0, String.format("Unit: %s", RandomStringUtils.randomAlphanumeric(5)));
        _world = w;
    }

    @Override
    public boolean move(int x, int y) {
        GameObject newLocation = _world.getCord(x , y);
        if (newLocation == null) {
            _world.moveObject(this, x, y);
            System.out.println(String.format("Moving %s to (%d, %d)", id(), x, y));
            return true;
        }

        System.out.println("Cannot Move.");
        return false;
    }

}
