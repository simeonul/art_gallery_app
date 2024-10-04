package connections;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import models.model.ArtPiece;
import models.model.ArtPieceArtist;
import models.model.Artist;
import models.model.Users;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArtPieceArtistConnection {
    private static final String PATH = "http://localhost:8080/artgallery/artpiece";
    private static final String GET = "GET";
    private static final String DELETE = "DELETE";
    private static final String POST = "POST";
    private static final String PUT = "PUT";


    @SneakyThrows
    private List<ArtPieceArtist> getAllArtPieceArtistAsList(HttpURLConnection connection) {
        List<ArtPieceArtist> artPieceArtistList = new ArrayList<>();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            artPieceArtistList = new ObjectMapper().readValue(response.toString(), new TypeReference<>() {
            });
            in.close();
        } else {
            System.out.println("Error occured while calling GET endpoint for ArtPieceArtist");
        }
        return artPieceArtistList;
    }

    @SneakyThrows
    private List<Artist> getAllArtistAsList(HttpURLConnection connection) {
        List<Artist> artistList = new ArrayList<>();
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            artistList = new ObjectMapper().readValue(response.toString(), new TypeReference<>() {
            });
            in.close();
        } else {
            System.out.println("Error occured while calling GET endpoint for ArtPieceArtist");
        }
        return artistList;
    }

    public List<ArtPieceArtist> getNotSoldArtPieceArtist(){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/not-sold", GET);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<ArtPieceArtist> getAllArtPieceArtist(){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH, GET);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<ArtPieceArtist> sortArtPieceArtist(){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/sort", GET);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<ArtPieceArtist> sortNotSoldArtPieceArtist(){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/not-sold/sort", GET);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<ArtPieceArtist> filterNotSoldArtPieceArtist(Map<String, String> filters){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/not-sold/filter", POST);
        ConnectionHelper.postWithParam(filters, connection);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<ArtPieceArtist> filterArtPieceArtist(Map<String, String> filters){
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/filter", POST);
        ConnectionHelper.postWithParam(filters, connection);
        return getAllArtPieceArtistAsList(connection);
    }

    public List<Artist> getAllArtists() {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/artist", GET);
        return getAllArtistAsList(connection);
    }

    @SneakyThrows
    public void addArtist(Artist artist) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/artist", POST);
        ConnectionHelper.postEntity(artist, connection, Artist.class);
    }


    @SneakyThrows
    public void updateArtist(int id, Artist artist) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/artist/" + id, PUT);
        ConnectionHelper.postEntity(artist, connection, Artist.class);
    }


    @SneakyThrows
    public void deleteArtist(int id) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/artist/" + id, DELETE);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        System.out.println(connection.getResponseCode());
    }

    public void addArtPiece(ArtPiece artPiece) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH, POST);
        ConnectionHelper.postEntity(artPiece, connection, ArtPiece.class);
    }

    public void updateArtPiece(int id, ArtPiece artPiece) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/" + id, PUT);
        ConnectionHelper.postEntity(artPiece, connection, ArtPiece.class);
    }

    @SneakyThrows
    public void deleteArtPiece(int id) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/" + id, DELETE);
        connection.setDoInput(true);
        connection.setDoOutput(true);
        System.out.println(connection.getResponseCode());
    }

    @SneakyThrows
    public void sellArtPiece(int id) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/sell/" + id, GET);
        System.out.println(connection.getResponseCode());
    }

    @SneakyThrows
    public void export(String type) {
        HttpURLConnection connection = ConnectionHelper.getConnection(PATH + "/export/" + type, GET);
        System.out.println(connection.getResponseCode());
    }
}
