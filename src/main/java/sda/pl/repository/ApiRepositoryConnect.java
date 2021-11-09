package sda.pl.repository;


import  com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;


public class ApiRepositoryConnect<T> {
    private final HttpClient client = HttpClient.newHttpClient();
    private final Class<T> modelClass;
    private final ObjectMapper mapper = new ObjectMapper();
    private final Map<Integer, T> cache = new HashMap<>();

    public ApiRepositoryConnect(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    /*
    Returns api body response string if status code equals 200 otherwise returns empty string
     */
    private String getBody(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(uri)
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            return "";
        }
        return response.body();
    }

    /*
    Returns an optional of specified object domain if api body string response was valid
    otherwise returns empty optional
     */
    public Optional<T> get(URI uri) throws IOException, InterruptedException {
        String apiBodyResponse = getBody(uri);
        if (apiBodyResponse.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(mapper.readValue(apiBodyResponse, modelClass));
    }

}
