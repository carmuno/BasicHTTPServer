package http.server.configuration.routeConfig;


import com.sun.net.httpserver.HttpHandler;
import http.server.requestHandler.body.StaticResponseHandler;

import java.util.Map;

/**
 * Configuración específica para rutas que devuelven respuestas estáticas.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class StaticResponseRouteSettings extends BaseRouteSettings {

    /**
     * El response body
     */
    private final String responseBody;

    /**
     * El content type
     */
    private final String contentType;

    public StaticResponseRouteSettings(String responseBody, String contentType,
                                       Map<String, String> headers,
                                       Map<String, String> cookies, int code) {
        super(headers, cookies, code);
        this.responseBody = responseBody;
        this.contentType = contentType;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public String getContentType() {
        return contentType;
    }

    @Override
    public HttpHandler createHandler() {
        return new StaticResponseHandler(this);
    }
}
