package http.server.requestHandler;

import com.sun.net.httpserver.HttpHandler;
import http.server.configuration.routeConfig.BaseRouteSettings;

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
}
