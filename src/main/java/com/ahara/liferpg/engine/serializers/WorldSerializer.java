package com.ahara.liferpg.engine.serializers;

import com.ahara.liferpg.engine.gameObjects.World;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

public class WorldSerializer implements  JsonSerializer<World> {
    private GsonBuilder gsonBuilder;

    public WorldSerializer(GsonBuilder g) {
        gsonBuilder = g;
    }

    @Override
    public JsonElement serialize(final World world, final Type typeOfSrc, final JsonSerializationContext context) {
        final Gson gson = gsonBuilder.create();

        final JsonObject jsonObject = new JsonObject();
        final JsonArray allUnits = new JsonArray();
        world.allObjects().forEach((g) -> allUnits.add(gson.toJson(g)));
        jsonObject.add("units", allUnits);

        return jsonObject;
    }
}
