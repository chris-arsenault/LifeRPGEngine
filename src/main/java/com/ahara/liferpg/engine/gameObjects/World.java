package com.ahara.liferpg.engine.gameObjects;

import java.util.ArrayList;
import java.util.List;

public class World extends GameObject {
    private static int WORLD_SIZE = 1000;
    private GameObject[][] _grid;
    private ArrayList<GameObject> _objects;

    public World() {
        _grid = new GameObject[WORLD_SIZE][WORLD_SIZE];
        _objects = new ArrayList<>();
    }

    public synchronized void addObject(GameObject target, int x, int y) {
        if (x > 0 && y > 0 && x < WORLD_SIZE && y < WORLD_SIZE && _grid[x][y] == null) {
            _grid[x][y] = target;
            target.setLocation(x, y);
            _objects.add(target);
        }
    }

    public ArrayList<GameObject> allObjects() {
        return _objects;
    }

    public GameObject getCord(int x, int y) {
        if (x > 0 && y > 0 && x < WORLD_SIZE && y < WORLD_SIZE) {
            return _grid[x][y];
        }
        return new GameObject();
    }

    public synchronized void moveObject(GameObject target, int x, int y) {
        if (x > 0 && y > 0 && x < WORLD_SIZE && y < WORLD_SIZE) {
            _grid[x][y] = target;
            _grid[target.x()][target.y()] = null;
            target.setLocation(x, y);
        } else {
            System.out.println("Invalid Move");
        }
    }

    public synchronized  void swapObjects(GameObject t1, GameObject t2) {
        _grid[t2.x()][t2.y()] = t1;
        _grid[t1.x()][t1.y()] = t2;
        t1.setLocation(t2.x(), t2.y());
        t2.setLocation(t1.x(), t1.y());
    }
}
