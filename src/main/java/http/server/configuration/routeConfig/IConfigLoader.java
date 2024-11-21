package http.server.configuration.routeConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import http.server.configuration.serializer.RouteConfigSerializer;
import http.server.configuration.server.HttpServerSettings;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Objects;

/**
 * Interfaz para cargar configuraciones desde un archivo JSON.
 *
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public interface IConfigLoader {

    /**
     * Carga la configuración desde un archivo JSON ubicado en la carpeta resources.
     *
     * @param name Ruta relativa del archivo JSON.
     * @return Instancia de {@link HttpServerSettings}.
     */
    static HttpServerSettings getConfig(String name) {
        try (Reader reader = new InputStreamReader(
                Objects.requireNonNull(IConfigLoader.class.getClassLoader().getResourceAsStream(name)))) {
            Gson gson = createGson();
            return gson.fromJson(reader, HttpServerSettings.class);
        } catch (NullPointerException e) {
            throw new RuntimeException("Archivo de configuración no encontrado: " + name, e);
        } catch (Exception e) {
            throw new RuntimeException("Error al leer la configuración desde " + name, e);
        }
    }

    /**
     * Crea una instancia de Gson con un deserializador personalizado.
     *
     * @return Instancia configurada de {@link Gson}.
     */
    static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapter(BaseRouteSettings.class, new RouteConfigSerializer())
                .setPrettyPrinting()
                .create();
    }
}
