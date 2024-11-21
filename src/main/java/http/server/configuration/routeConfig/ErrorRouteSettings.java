package http.server.configuration.routeConfig;

import com.sun.net.httpserver.HttpHandler;
import http.server.requestHandler.error.ErrorHandler;

import java.util.Map;

/**
 * @author Carlos Noé Muñoz (cnoemunoz@gmail.com).
 */
public class ErrorRouteSettings extends BaseRouteSettings {

    private final String errorMessage;

    public ErrorRouteSettings(Map<String, String> headers, Map<String, String> cookies, int code, String errorMessage) {
        super(headers, cookies, code);
        this.errorMessage = errorMessage;
    }

    @Override
    public HttpHandler createHandler() {
        return new ErrorHandler(this);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
