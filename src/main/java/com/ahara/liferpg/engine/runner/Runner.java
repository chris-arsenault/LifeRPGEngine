package com.ahara.liferpg.engine.runner;
import com.ahara.liferpg.engine.gameObjects.World;
import com.ahara.liferpg.engine.rules.GameRule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Runner {

    private static Integer STEP_LENGTH = 1000;

    private World _w;
    private ArrayList<GameRule> _r;
    private RedisConnection _c;
    private RedisSerializer<String> serializer = new StringRedisSerializer();
    private Gson gson;

    @Autowired
    public Runner(LettuceConnectionFactory factory, GsonBuilder gsonBuilder) {
        _w = WorldInitalizer.initializeWorld();
        _r = RuleInitializer.initializeRules();
        _c = factory.getConnection();

        gson = gsonBuilder.create();
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
                System.out.println(e.getMessage());
            }
        }
    }

    private void doTurn() {
        //Accept Input
        //Run Pieces
        _w.allObjects().forEach((g) -> _r.forEach((r) -> r.applyTo(g)));
        //Garbage Collect
        //Save Board State
        String p = gson.toJson(_w);
        _c.set(serializer.serialize("World"), serializer.serialize(p));
        //Print BoardState
    }
}
