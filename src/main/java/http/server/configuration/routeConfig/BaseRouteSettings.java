package http.server.configuration.routeConfig;

import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;

import java.io.*;
import java.util.Objects;

/**
 * Clase base para las configuraciones de las rutas HTTP.
 * Define las propiedades comunes para todos los tipos de rutas.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public abstract class BaseRouteSettings implements IConfigLoader {

    /**
     * El tipo a asignar. (si es redirect, si es respuesta static)
     */
    protected String type;

    /**
     * Devuelve el handler asociado a esta configuración.
     *
     * @return {@link HttpHandler} asociado.
     */
    public abstract HttpHandler createHandler();
}

