package com.ahara.liferpg.engine.serializers;

import com.ahara.liferpg.engine.gameObjects.Unit;
import com.ahara.liferpg.engine.gameObjects.World;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SerializerConfiguration {

    @Bean
    GsonBuilder gsonBuilder() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(World.class, new WorldSerializer(gsonBuilder));
        gsonBuilder.registerTypeAdapter(Unit.class, new UnitSerializer());
//        gsonBuilder.setPrettyPrinting();

        return gsonBuilder;
    }
}
