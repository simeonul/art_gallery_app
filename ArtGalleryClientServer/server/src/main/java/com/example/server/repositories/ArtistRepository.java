package com.example.server.repositories;


import com.example.server.models.Artist;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ArtistRepository {
    private DatabaseManagement databaseManagement = DatabaseManagement.getInstance();

    public ArtistRepository(){
    }

    public List<Artist> getAllArtists(){
        List<Artist> artists = new ArrayList<>();
        String sqlStatement = "SELECT * FROM artist";
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int birthYear = resultSet.getInt("birth_year");
                String nationality = resultSet.getString("nationality");
                artists.add(new Artist(id, name, birthYear, nationality));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return artists;
    }

    public Optional<Artist> getArtistById(int id){
        Artist artist = null;
        String sqlStatement = "SELECT * FROM artist WHERE id = " + id;
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                String name = resultSet.getString("name");
                int birthYear = resultSet.getInt("birth_year");
                String nationality = resultSet.getString("nationality");
                artist = new Artist(id, name, birthYear, nationality);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return Optional.ofNullable(artist);
    }

    public void addArtist(Artist artist){
        String sqlStatement = "INSERT INTO artist(name, birth_year, nationality) VALUES" + artist.toQueryString();
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        try {
            selectStatement = connection.createStatement();
            selectStatement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
    }

    public void deleteArtist(int id) {
        String sqlStatement = "DELETE FROM artist WHERE id=" + id;
        Connection connection = databaseManagement.getConnection();
        Statement deleteStatement = null;
        try {
            deleteStatement = connection.createStatement();
            deleteStatement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(deleteStatement);
            databaseManagement.close(connection);
        }

    }

    public void updateArtist(int id, Artist updatedArtist) {
        String sqlStatement = "UPDATE artist SET " + updatedArtist.toUpdateQueryString() + " WHERE id=" + id;
        Connection connection = databaseManagement.getConnection();
        Statement updateStatement = null;
        try {
            updateStatement = connection.createStatement();
            updateStatement.execute(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(updateStatement);
            databaseManagement.close(connection);
        }
    }
}
