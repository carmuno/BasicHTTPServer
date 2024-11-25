
package http.server.configuration.server;

import java.util.List;

/**
 * Clase que representa la configuración de un servidor HTTP.
 * Permite definir una lista de configuraciones para múltiples servidores.
 *
 * @author Carlos Noe Muñoz (cnoemunoz@gmail.com)
 */
public class HttpServerSettings {

    /**
     * Lista de configuraciones de servidores.
     */
    private List<ServerConfig> servers;

    /**
     * Obtiene la lista de configuraciones de servidores.
     *
     * @return Lista de configuraciones de servidores.
     */
    public List<ServerConfig> getServers() {
        return servers;
    }

    /**
     * Establece la lista de configuraciones de servidores.
     *
     * @param servers Lista de configuraciones de servidores a establecer.
     */
    public void setServers(List<ServerConfig> servers) {
        this.servers = servers;
    }
}
