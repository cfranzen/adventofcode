package de.cfranzen.adventofcode2024.util;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

public class InputDownloader {

    private static final URI BASE_URI = URI.create("https://adventofcode.com/");
    private final HttpClient httpClient;
    private final String sessionId;

    public InputDownloader() {
        this.sessionId = loadSessionId();
        this.httpClient = HttpClient.newBuilder().build();
    }

    public List<String> downloadLines(int year, int day) {
        try (BufferedReader reader = download(year, day)) {
            return reader.lines().toList();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public BufferedReader download(int year, int day) {
        final URI uri = BASE_URI.resolve("/" + year + "/day/" + day + "/input");

        final HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("cookie", "session=" + sessionId)
                .GET()
                .build();

        try {
            final HttpResponse<InputStream> response = httpClient.send(request, BodyHandlers.ofInputStream());
            if (response.statusCode() < 200 || response.statusCode() >= 300) {
                throw new IllegalStateException("Unable to retrieve input: error " + response.statusCode() + "\n" + bodyToString(response));
            }
            return new BufferedReader(new InputStreamReader(response.body(), StandardCharsets.UTF_8));
        } catch (IOException | InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String loadSessionId() {
        final Properties properties = new Properties();
        try (final InputStream is = InputDownloader.class.getResourceAsStream("/application.properties")) {
            properties.load(is);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        final String sessionId = properties.getProperty("adventofcode.session-id");
        if (sessionId == null) {
            throw new IllegalStateException("Unable to load sessionId from application.properties");
        }
        return sessionId;
    }

    private static String bodyToString(final HttpResponse<InputStream> response) {
        final ByteArrayOutputStream result = new ByteArrayOutputStream();
        final byte[] buffer = new byte[1024];
        try (InputStream is = response.body()) {
            for (int length; (length = is.read(buffer)) != -1; ) {
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read HTTP response body", e);
        }
        return result.toString(StandardCharsets.UTF_8);
    }
}
