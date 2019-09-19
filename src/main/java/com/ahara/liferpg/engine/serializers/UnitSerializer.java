package com.ahara.liferpg.engine.serializers;

import com.ahara.liferpg.engine.gameObjects.Unit;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;

@Service
public class UnitSerializer implements  JsonSerializer<Unit> {
    @Override
    public JsonElement serialize(final Unit unit, final Type typeOfSrc, final JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", unit.x());
        jsonObject.addProperty("x", unit.y());
        jsonObject.addProperty("x", unit.id());

        return jsonObject;
    }
}
