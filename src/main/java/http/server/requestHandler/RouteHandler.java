package http.server.requestHandler;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import http.server.configuration.routeConfig.BaseRouteSettings;

import java.io.IOException;

/**
 * Handler que recibe el parametro de config, donde se le especificara como quiere
 * que sea la respuesta. Actualmente posible de dos tipos.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public abstract class RouteHandler<T extends BaseRouteSettings> implements HttpHandler {

    /**
     * La configuración asociada.
     */
    protected T config;

    /**
     * La contrución, a tarves de la configuración asignada.
     * @param config la configuración asociada.
     */
    public RouteHandler(T config) {
        this.config = config;
    }

    /**
     * Cómo va a manejar cada conexto su respuesta.
     */
    protected abstract void handleRequest(HttpExchange exchange)
    throws IOException;

    /**
     * Parametros comunes en la interceptación de la request.
     *
     * @param exchange el exchange contiene la request del cliente y es usada para
     *                 enviar la respuesta al cliente.
     * @throws IOException Si ocurrio una exception durante el procesado.
     */
    @Override
    public void handle(HttpExchange exchange)
    throws IOException {
        if(config.getHeaders()!=null) {
            config.getHeaders().forEach(exchange.getResponseHeaders()::add);
        }
        if(config.getCookies()!=null){
            config.getCookies().forEach((key, value) -> {
                String cookie = key + "=" + value + "; Path=/; HttpOnly";
                exchange.getResponseHeaders().add("Set-Cookie", cookie);
            });
        }
        handleRequest(exchange);
    }
}
