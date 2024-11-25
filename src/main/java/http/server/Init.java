package http.server;

import http.server.configuration.routeConfig.IConfigLoader;
import http.server.configuration.server.HttpServerSettings;
import http.server.configuration.server.ServerConfig;

/**
 * Clase principal para inicializar el servidor ligero.
 * Configura el puerto y delega la creación del servidor a la clase {@link InitServer}.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class Init {

    /**
     * Método principal que inicia el servidor en el puerto configurado.
     *
     * @param args Argumentos de la línea de comandos (no utilizados en esta implementación).
     */
    public static void main(String[] args) {

        HttpServerSettings serverConfig = IConfigLoader.getConfig("info.json");
        //una vez que tenemos la configuración de nuestro servidor ligero de redireciones, arrancamos.
        InitServer initServer = new InitServer(serverConfig);
    }
}
