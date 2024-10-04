package connections;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ConnectionHelper {

    @SneakyThrows
    public static HttpURLConnection getConnection(String path, String type){
        URL url = new URL(path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(type);
        return connection;
    }

    @SneakyThrows
    public static void postEntity(Object object, HttpURLConnection connection, Class targetClass) {
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setDoOutput(true);
        String toBeSent = new ObjectMapper().writeValueAsString(targetClass.cast(object));
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = toBeSent.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        System.out.println(connection.getResponseCode());
    }

    @SneakyThrows
    public static void postWithParam(Map<String, String> params, HttpURLConnection connection) {
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        StringBuilder queryParams = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (queryParams.length() > 0) {
                queryParams.append("&");
            }
            queryParams.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            queryParams.append("=");
            queryParams.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String toBeSent = queryParams.toString();
        try(OutputStream os = connection.getOutputStream()) {
            byte[] input = toBeSent.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
    }
}
