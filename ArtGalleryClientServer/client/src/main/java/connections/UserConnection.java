package connections;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.model.ArtPiece;
import models.model.Users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserConnection {
    private static final String PATH = "http://localhost:8080/artgallery/users";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";
    private static final String POST = "POST";
    private static final String PUT = "PUT";
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserConnection() {

    }

    @SneakyThrows
    private Optional<Users> getUser(HttpURLConnection connection) {
        Users responseUser = new Users();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            responseUser = objectMapper.readValue(response.toString(), Users.class);
            in.close();
        } else {
            System.out.println("GET request did not work.");
        }
        return Optional.of(responseUser);
    }

    @SneakyThrows
    private List<Users> getAllAsList(HttpURLConnection connection) {
        List<Users> users = new ArrayList<>();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            users = new ObjectMapper().readValue(response.toString(), new TypeReference<>() {
            });
            in.close();
            System.out.println(response);
        } else {
            System.out.println("GET request did not work.");
        }
        return users;
    }

    @SneakyThrows
    public void addUser(Users user) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH, POST);
        ConnectionHelper.postEntity(user, connection, Users.class);
    }

    @SneakyThrows
    public Optional<Users> getUserByEmail(String email) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/" + email, GET);
        return getUser(connection);
    }

    public void updateUser(int id, Users user) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/" + id, PUT);
        ConnectionHelper.postEntity(user, connection, Users.class);
    }

    @SneakyThrows
    public void deleteUser(int id) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/" + id, DELETE);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        System.out.println(connection.getResponseCode());
    }

    @SneakyThrows
    public List<Users> getAllUser() {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH, GET);
        return getAllAsList(connection);
    }
}
