package http.server.requestHandler.redirect;

import com.sun.net.httpserver.HttpExchange;
import http.server.configuration.routeConfig.RedirectRouteSettings;
import http.server.requestHandler.RouteHandler;

import java.io.IOException;

/**
 * Handler que procesa rutas con redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class RedirectHandler extends RouteHandler<RedirectRouteSettings> {

    /**
     * header de redirección. la siguiente url a la que llamar.
     */
    private static final String REDIRECTION_HEADER = "Location";

    public RedirectHandler(RedirectRouteSettings config) {
        super(config);
    }

    @Override
    public void handleRequest(HttpExchange exchange)
    throws IOException {
        String queryParams = config.appendQueryParams();
        exchange.getResponseHeaders().add(REDIRECTION_HEADER, config.getRedirectUrl() + queryParams);
        exchange.sendResponseHeaders(config.getCode(), -1);
    }
}
