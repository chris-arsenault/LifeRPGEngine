package com.ahara.liferpg.engine.runner;

import com.ahara.liferpg.engine.rules.GameRule;
import com.ahara.liferpg.engine.rules.MoveLeft;

import java.util.ArrayList;

public class RuleInitializer {
    public static ArrayList<GameRule> initializeRules() {
        ArrayList<GameRule> a = new ArrayList<GameRule>();
        a.add(new MoveLeft());

        return a;
    }
}
