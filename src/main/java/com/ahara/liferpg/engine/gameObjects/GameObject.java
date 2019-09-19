package com.ahara.liferpg.engine.gameObjects;

public class GameObject {
    private int _x;
    private int _y;
    private boolean _valid = false;
    private String _id;

    public GameObject(int x, int y, String id) {
        _x = x;
        _y = y;
        _id = id;
        _valid = true;
    }

    public GameObject() {
    }

    public boolean Invalid() {
        return !_valid;
    }


    public void setLocation(int x, int y) {
        _x = x;
        _y = y;
    }

    public int x() {
        return _x;
    }

    public int y() {
        return _y;
    }

    public String id() {
        return _id;
    }

}
