package http.server.configuration.serializer;

import com.google.gson.*;
import http.server.configuration.routeConfig.BaseRouteSettings;
import http.server.configuration.routeConfig.RedirectRouteSettings;
import http.server.configuration.routeConfig.StaticResponseRouteSettings;

import java.lang.reflect.Type;

/**
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class RouteConfigSerializer implements JsonDeserializer<BaseRouteSettings> {

    /**
     * Campo del json que me dice el tipo de petición.
     */
    private static final String TYPE_FIELD = "type";

    @Override
    public BaseRouteSettings deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
    throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String type = jsonObject.get(TYPE_FIELD).getAsString();

        switch (type) {
            case "redirect":
                return context.deserialize(jsonObject, RedirectRouteSettings.class);
            case "static":
                return context.deserialize(jsonObject, StaticResponseRouteSettings.class);
            default:
                throw new JsonParseException("Tipo desconocido: " + type);
        }
    }
}
