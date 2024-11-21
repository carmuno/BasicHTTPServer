package http.server;

import http.server.configuration.routeConfig.BaseRouteSettings;
import http.server.configuration.routeConfig.IConfigLoader;
import http.server.configuration.serializer.RouteConfigSerializer;
import http.server.configuration.server.HttpServerSettings;

/**
 * Clase principal para inicializar el servidor ligero.
 * Configura el puerto y delega la creación del servidor a la clase {@link InitServer}.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class Init {

    /**
     * Puerto de arranque de nuestro servidor ligero.
     */
    private static final int PORT = 8080;

    /**
     * Método principal que inicia el servidor en el puerto configurado.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {

        HttpServerSettings httpServerSettings = IConfigLoader.getConfig("info.json");

        //una vez que tenemos la configuración de nuestro servidor ligero de redireciones, arrancamos.
        InitServer initServer = new InitServer(httpServerSettings);
    }
}
