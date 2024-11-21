package http.server.configuration.routeConfig;

import com.sun.net.httpserver.HttpHandler;

import java.util.Map;

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
     * Las headers.
     */
    private final Map<String, String> headers;

    /**
     * Las cookies asociadas.
     */
    private final Map<String, String> cookies;

    /**
     * El code de respuesta http,
     */
    private final int code;

    public BaseRouteSettings(Map<String, String> headers,
                             Map<String, String> cookies,
                             int code) {
        this.headers = headers;
        this.cookies = cookies;
        this.code = code;
    }

    /**
     * Obtenemos las header.
     *
     * @return Las headers.
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Obtenemos las cookies.
     *
     * @return Las cookies.
     */
    public Map<String, String> getCookies() {
        return cookies;
    }

    /**
     * El codigo de respuesta http.
     *
     * @return código de respuesta http.
     */
    public int getCode() {
        return code;
    }

    /**
     * Devuelve el handler asociado a esta configuración.
     *
     * @return {@link HttpHandler} asociado.
     */
    public abstract HttpHandler createHandler();
}

