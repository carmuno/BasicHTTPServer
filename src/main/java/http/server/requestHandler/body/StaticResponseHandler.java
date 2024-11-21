package http.server.requestHandler.body;

import com.sun.net.httpserver.HttpExchange;
import http.server.configuration.routeConfig.StaticResponseRouteSettings;
import http.server.requestHandler.RouteHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handler que procesa rutas con respuestas estáticas.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class StaticResponseHandler extends RouteHandler<StaticResponseRouteSettings> {

    public StaticResponseHandler(StaticResponseRouteSettings config) {
        super(config);
    }

    @Override
    public void handleRequest(HttpExchange exchange)
    throws IOException {
        exchange.getResponseHeaders().add("Content-Type", config.getContentType());
        String response = config.getResponseBody();
        exchange.sendResponseHeaders(config.getCode(), response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
