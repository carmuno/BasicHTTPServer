package http.server.requestHandler;

import com.sun.net.httpserver.HttpExchange;
import http.server.configuration.routeConfig.RedirectRouteSettings;

import java.io.IOException;

/**
 * Handler que procesa rutas con redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class RedirectHandler extends RouteHandler<RedirectRouteSettings> {

    public RedirectHandler(RedirectRouteSettings config) {
        super(config);
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        exchange.getResponseHeaders().add("Location", config.getRedirectUrl());
        exchange.sendResponseHeaders(config.getRedirectCode(), -1);
    }
}
