package http.server.configuration.routeConfig;

import com.sun.net.httpserver.HttpHandler;
import http.server.requestHandler.RedirectHandler;

/**
 * Configuración específica para rutas que realizan redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class RedirectRouteSettings extends BaseRouteSettings {

    private final String redirectUrl;
    private final int redirectCode;

    public RedirectRouteSettings(String redirectUrl, int redirectCode) {
        this.redirectUrl = redirectUrl;
        this.redirectCode = redirectCode;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public int getRedirectCode() {
        return redirectCode;
    }

    @Override
    public HttpHandler createHandler() {
        return new RedirectHandler(this);
    }
}
