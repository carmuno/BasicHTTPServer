package http.server.configuration.server;

import http.server.configuration.routeConfig.BaseRouteSettings;

import java.util.Map;

/**
 * Clase que define la configuración global para el servidor HTTP.
 * incluye el puerto de arranque y como queremos que se manejen las rutas y bajo que condiciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class ServerConfig {

    /**
     * El nombre del host.
     */
    private final String hostName;

    /**
     * Puerto de arranque del servidor.
     */
    public final int defaultPort;

    /**
     * Mapa de rutas asociadas y sus configuraciones.
     * Ejemplo: "/" : {redirectUrl, redirectCode, ...}, "/cnoe" : {...}
     */
    public final Map<String, BaseRouteSettings> routes;

    /**
     * Constructor que inicializa la configuración del servidor.
     *
     * @param defaultPort Puerto en el que el servidor escuchará.
     * @param routes Mapa que define las rutas y sus configuraciones asociadas.
     */
    public ServerConfig(String hostName, int defaultPort, Map<String, BaseRouteSettings> routes) {
        this.hostName = hostName;
        this.defaultPort = defaultPort;
        this.routes = routes;
    }

    /**
     * Obtiene el mapa de rutas y sus configuraciones.
     *
     * @return Mapa de rutas.
     */
    public Map<String, BaseRouteSettings> getRoutes() {
        return routes;
    }

    /**
     * Obtiene el puerto de arranque del servidor.
     *
     * @return Puerto del servidor.
     */
    public int getDefaultPort() {
        return defaultPort;
    }

    /**
     * Obtiene el nombre del host.
     * @return
     */
    public String getHostName() {
        return hostName;
    }
}
