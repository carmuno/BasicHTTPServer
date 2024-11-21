package http.server.configuration.routeConfig;

import com.sun.net.httpserver.HttpHandler;
import http.server.requestHandler.redirect.RedirectHandler;

import java.util.Map;

/**
 * Configuración específica para rutas que realizan redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class RedirectRouteSettings extends BaseRouteSettings {

    /**
     * la redirección url.
     */
    private final String redirectUrl;

    /**
     * Los params aue va a recibir la redirección.
     */
    private final Map<String, String> queryParams;

    public RedirectRouteSettings(String redirectUrl, Map<String, String> headers, Map<String, String> cookies, Map<String, String> queryParams, int code) {
        super(headers, cookies, code);
        this.redirectUrl = redirectUrl;
        this.queryParams = queryParams;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    /**
     * Me proporciona los parametros de la query en formato de query.
     *
     * @return Los parametros de la query en formato de query.
     */
    public String appendQueryParams() {
        StringBuilder sb = new StringBuilder();
        if (queryParams!=null && !queryParams.isEmpty()) {
            queryParams.forEach((key, value) -> sb.append(key).append("=").append(value).append("&"));
            sb.setLength(sb.length() - 1); // Eliminar el último '&'
        }
        return sb.toString();
    }


    @Override
    public HttpHandler createHandler() {
        return new RedirectHandler(this);
    }
}
