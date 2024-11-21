package http.server.requestHandler.error;

import com.sun.net.httpserver.HttpExchange;
import http.server.configuration.routeConfig.ErrorRouteSettings;
import http.server.requestHandler.RouteHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * implementación de un mensaje de error.
 * Se construirá ese contexto cuando queramos que bajo cierta ruta, nos de error.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class ErrorHandler extends RouteHandler<ErrorRouteSettings> {

    /**
     * La contrución, a tarves de la configuración asignada.
     *
     * @param config la configuración asociada.
     */
    public ErrorHandler(ErrorRouteSettings config) {
        super(config);
    }

    @Override
    protected void handleRequest(HttpExchange exchange) throws IOException {

        exchange.getResponseHeaders().add("Content-Type", "application/json");

        String responseBody = String.format(
                "{\"error\": \"%s\", \"code\": %d}",
                config.getErrorMessage(), config.getCode()
        );

        exchange.sendResponseHeaders(config.getCode(), responseBody.getBytes().length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(responseBody.getBytes());
        }
    }
}
