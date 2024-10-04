package com.example.server.repositories;




import com.example.server.models.ArtPiece;
import com.example.server.models.enums.ArtForm;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class ArtPieceRepository {
    private DatabaseManagement databaseManagement = DatabaseManagement.getInstance();

    public ArtPieceRepository(){
    }

    public List<ArtPiece> getAllArtPieces(){
        List<ArtPiece> artPieces = new ArrayList<>();
        String sqlStatement = "SELECT * FROM art_piece";
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int artistId = resultSet.getInt("artist_id");
                ArtForm artForm = ArtForm.valueOf(resultSet.getString("art_form"));
                int year = resultSet.getInt("year");
                float price = resultSet.getInt("price");
                boolean isSold = resultSet.getBoolean("is_sold");
                artPieces.add(new ArtPiece(id, title, artistId, artForm, year, price, isSold));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return artPieces;
    }

    public Optional<ArtPiece> getArtPieceById(int id){
        ArtPiece artPiece = null;
        String sqlStatement = "SELECT * FROM art_piece WHERE id = " + id;
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                String title = resultSet.getString("title");
                int artistId = resultSet.getInt("artist_id");
                ArtForm artForm = ArtForm.valueOf(resultSet.getString("art_form"));
                int year = resultSet.getInt("year");
                float price = resultSet.getInt("price");
                boolean isSold = resultSet.getBoolean("is_sold");
                artPiece = new ArtPiece(id, title, artistId, artForm, year, price, isSold);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return Optional.ofNullable(artPiece);
    }

    public void addArtPiece(ArtPiece artPiece){
        String sqlStatement = "INSERT INTO art_piece(title, artist_id, art_form, year, price, is_sold) VALUES" + artPiece.toQueryString();
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

    public void deleteArtPiece(int id) {
        String sqlStatement = "DELETE FROM art_piece WHERE id=" + id;
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

    public void updateArtPiece(int id, ArtPiece updatedArtPiece) {
        String sqlStatement = "UPDATE art_piece SET " + updatedArtPiece.toUpdateQueryString() + " WHERE id=" + id;
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
