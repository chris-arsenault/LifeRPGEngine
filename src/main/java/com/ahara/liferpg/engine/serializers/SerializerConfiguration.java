package com.ahara.liferpg.engine.serializers;

import com.ahara.liferpg.engine.gameObjects.Unit;
import com.ahara.liferpg.engine.gameObjects.World;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerializerConfiguration {

    @Autowired
    WorldSerializer worldSerializer;

    @Autowired
    UnitSerializer unitSerializer;

    @Bean
    GsonBuilder gsonBuilder() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(World.class, worldSerializer);
        gsonBuilder.registerTypeAdapter(Unit.class, unitSerializer);
        gsonBuilder.setPrettyPrinting();

        return gsonBuilder;
    }
}
