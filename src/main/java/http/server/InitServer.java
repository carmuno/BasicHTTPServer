package http.server;

import com.sun.net.httpserver.HttpServer;
import http.server.configuration.routeConfig.BaseRouteSettings;
import http.server.configuration.server.HttpServerSettings;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

/**
 * Encargada de iniciar un servidor ligero para escuchar las peticiones.
 * En principio todas las peticiones serán tratadas para las redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class InitServer {

    /**
     * Contrución de arranque de nuestro servidor.
     */
    public InitServer(HttpServerSettings httpServerSettings) {
        try {
            HttpServer server = configureServer(httpServerSettings);
            startServer(server, httpServerSettings.getDefaultPort());
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Configura las rutas y handlers del servidor.
     *
     * @param httpServerSettings la configuración del servidor.
     * @return Instancia configurada de {@link HttpServer}.
     * @throws IOException Si ocurre un error al crear el servidor.
     */
    private HttpServer configureServer(HttpServerSettings httpServerSettings) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(httpServerSettings.getDefaultPort()), 0);

        for (Map.Entry<String, BaseRouteSettings> route : httpServerSettings.getRoutes().entrySet()) {
            server.createContext(route.getKey(), route.getValue().createHandler());
        }

        server.setExecutor(null);
        return server;
    }

    /**
     * Inicia el servidor y muestra un mensaje en la consola.
     *
     * @param server Instancia de {@link HttpServer}.
     * @param port   Puerto del servidor.
     */
    private void startServer(HttpServer server, int port) {
        server.start();
        System.out.println("Servidor iniciado en el puerto " + port);
    }
}