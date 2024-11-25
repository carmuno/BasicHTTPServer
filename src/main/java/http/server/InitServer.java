package http.server;

import com.sun.net.httpserver.HttpServer;
import http.server.configuration.routeConfig.BaseRouteSettings;
import http.server.configuration.server.HttpServerSettings;
import http.server.configuration.server.ServerConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.Map;

/**
 * Encargada de iniciar un servidor ligero para escuchar las peticiones.
 * En principio todas las peticiones serán tratadas para las redirecciones.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class InitServer {

    /**
     * Construción de arranque de nuestro servidor/es
     */
    public InitServer(HttpServerSettings serverSettings) {
        try {
            configureServer(serverSettings);
        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Configura las rutas y handlers del servidor.
     *
     * @param serverSettings la configuración del servidor/es
     * @return Instancia configurada de {@link HttpServer}.
     * @throws IOException Si ocurre un error al crear el servidor.
     */
    private void configureServer(HttpServerSettings serverSettings) throws IOException {

        serverSettings.getServers().forEach((httpServerSetting)-> {
            HttpServer server = null;
            try {
                server = HttpServer.create(new InetSocketAddress(httpServerSetting.getDefaultPort()), 0);
            } catch (IOException e) {
                System.err.println("El servidor ha fallado al iniciarse en el puerto " + httpServerSetting.defaultPort);
            }

            if(server == null){
                return;
            }

            for (Map.Entry<String, BaseRouteSettings> route : httpServerSetting.getRoutes().entrySet()) {
                server.createContext(route.getKey(), route.getValue().createHandler());
            }

            server.setExecutor(null);
            startServer(server, httpServerSetting.getDefaultPort());
        });
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