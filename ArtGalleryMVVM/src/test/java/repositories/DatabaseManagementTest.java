package repositories;


import models.repositories.DatabaseManagement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class DatabaseManagementTest {

    @Test
    void testDropDatabase(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        boolean anwear = false;
        anwear = databaseManagement.doesDatabaseExist();
        Assertions.assertTrue(anwear);
        databaseManagement.dropDatabase();
        anwear = databaseManagement.doesDatabaseExist();
        Assertions.assertFalse(anwear);
    }

    @Test
    void testCreateDatabase(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        boolean anwear = false;
        anwear = databaseManagement.doesDatabaseExist();
        Assertions.assertFalse(anwear);
        databaseManagement.createDatabase();
        anwear = databaseManagement.doesDatabaseExist();
        Assertions.assertTrue(anwear);
    }


    @Test
    void testCreateUsersTable(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        boolean anwear = false;
        anwear = databaseManagement.doesTableExist("users");
        Assertions.assertFalse(anwear);
        databaseManagement.createUsersTable();
        anwear = databaseManagement.doesTableExist("users");
        Assertions.assertTrue(anwear);

        List<String> columns = databaseManagement.getTableColumns("users");
        Assertions.assertEquals(columns.get(0), "id");
        Assertions.assertEquals(columns.get(1), "email");
        Assertions.assertEquals(columns.get(2), "password");
        Assertions.assertEquals(columns.get(3), "user_type");
        Assertions.assertEquals(columns.get(4), "phone");
        Assertions.assertEquals(columns.get(5), "address");
        Assertions.assertEquals(columns.get(6), "is_enabled");
        Assertions.assertEquals(columns.size(), 7);
    }

    @Test
    void testCreateArtistTable(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        boolean anwear = false;
        anwear = databaseManagement.doesTableExist("artist");
        Assertions.assertFalse(anwear);
        databaseManagement.createArtistTable();
        anwear = databaseManagement.doesTableExist("artist");
        Assertions.assertTrue(anwear);

        List<String> columns = databaseManagement.getTableColumns("artist");
        Assertions.assertEquals(columns.get(0), "id");
        Assertions.assertEquals(columns.get(1), "name");
        Assertions.assertEquals(columns.get(2), "birth_year");
        Assertions.assertEquals(columns.get(3), "nationality");
        Assertions.assertEquals(columns.size(), 4);
    }

    @Test
    void testCreateArtPieceTable(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        boolean anwear = false;
        anwear = databaseManagement.doesTableExist("art_piece");
        Assertions.assertFalse(anwear);
        databaseManagement.createArtPieceTable();
        anwear = databaseManagement.doesTableExist("art_piece");
        Assertions.assertTrue(anwear);

        List<String> columns = databaseManagement.getTableColumns("art_piece");
        Assertions.assertEquals(columns.get(0), "id");
        Assertions.assertEquals(columns.get(1), "title");
        Assertions.assertEquals(columns.get(2), "artist_id");
        Assertions.assertEquals(columns.get(3), "art_form");
        Assertions.assertEquals(columns.get(4), "year");
        Assertions.assertEquals(columns.get(5), "price");
        Assertions.assertEquals(columns.get(6), "is_sold");
        Assertions.assertEquals(columns.size(), 7);
    }

    @Test
    void testDatabaseConnection(){
        DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
        Connection connection = databaseManagement.getConnection();
        boolean result = false;
        try{
            result = connection != null && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(result);
        databaseManagement.close(connection);
    }



}