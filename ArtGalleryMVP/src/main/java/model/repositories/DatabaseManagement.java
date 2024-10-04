package model.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManagement {
    private final String DB_URL = "jdbc:postgresql://localhost:5432/";
    private final String DB_USER = "postgres";
    private final String DB_PASSWORD = "postgres";
    private final String DB_NAME = "art_gallery_mvp";

    private static DatabaseManagement singleInstance = new DatabaseManagement();

    private DatabaseManagement() {
    }

    public static DatabaseManagement getInstance() {
        return singleInstance;
    }

    public void createDatabase() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement createStatement = connection.createStatement();
            String sqlStatement = "CREATE DATABASE " + DB_NAME + " WITH OWNER = " + DB_USER;
            createStatement.executeUpdate(sqlStatement);
            System.out.println("Database created successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropDatabase() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement createStatement = connection.createStatement();
            String sqlStatement = "DROP DATABASE " + DB_NAME;
            createStatement.executeUpdate(sqlStatement);
            System.out.println("Database dropped successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        String db = DB_URL + DB_NAME;
        try {
            connection = DriverManager.getConnection(db, DB_USER, DB_PASSWORD);
            //System.out.println("Connected to the " + DB_NAME + " database successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public void createUsersTable() {
        Connection connection = getConnection();
        String sqlEnumStatement = "CREATE TYPE user_type AS ENUM ('VISITOR', 'EMPLOYEE', 'ADMINISTRATOR')";
        String sqlStatement = "CREATE TABLE users " +
                "(id serial PRIMARY KEY," +
                "email VARCHAR (50) UNIQUE NOT NULL," +
                "password VARCHAR (50) NOT NULL," +
                "user_type user_type NOT NULL," +
                "phone VARCHAR (15) UNIQUE NOT NULL," +
                "address VARCHAR (50) NOT NULL," +
                "is_enabled boolean NOT NULL);";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlEnumStatement);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void dropUsersTable() {
        Connection connection = getConnection();
        String sqlEnumStatement = "DROP TYPE IF EXISTS user_type CASCADE";
        String sqlStatement = "DROP TABLE IF EXISTS users CASCADE";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlEnumStatement);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createArtistTable() {
        Connection connection = getConnection();
        String sqlStatement = "CREATE TABLE artist " +
                "(id SERIAL PRIMARY KEY," +
                "name VARCHAR (50) NOT NULL," +
                "birth_year integer," +
                "nationality VARCHAR (50));";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void createArtPieceTable() {
        Connection connection = getConnection();
        String sqlEnumStatement = "CREATE TYPE art_form AS ENUM ('PAINTING', 'SCULPTURE', 'ARCHITECTURE', 'LITERATURE','MUSIC', " +
                "'CINEMA','THEATER');";
        String sqlStatement = "CREATE TABLE art_piece " +
                "(id SERIAL PRIMARY KEY," +
                "title VARCHAR (50) NOT NULL," +
                "artist_id INTEGER NOT NULL REFERENCES artist(id) ON DELETE CASCADE," +
                "art_form art_form NOT NULL," +
                "year INTEGER," +
                "price REAL);";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlEnumStatement);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropArtistTable() {
        Connection connection = getConnection();
        String sqlStatement = "DROP TABLE IF EXISTS artist";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropArtPieceTable() {
        Connection connection = getConnection();
        String sqlEnumStatement = "DROP TYPE IF EXISTS art_form CASCADE";
        String sqlStatement = "DROP TABLE IF EXISTS art_piece CASCADE";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlEnumStatement);
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void dropType(String type) {
        Connection connection = getConnection();
        String sqlStatement = "DROP TYPE IF EXISTS " + type;
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlStatement);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("An error occured while trying to close the connection");
            }
        }
    }

    public void close(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("An error occured while trying to close the statement");
            }
        }
    }

    public void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("An error occured while trying to close the ResultSet");
            }
        }
    }


    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public boolean doesDatabaseExist() {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        boolean answear = false;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            String sqlStatement =
                    "        select exists(\n" +
                            "                SELECT datname FROM pg_catalog.pg_database WHERE lower(datname) = lower('art_gallery_mvp')\n" +
                            "        );";
            resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                answear = resultSet.getBoolean("exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return answear;
    }

    public boolean doesTableExist(String tableName){
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        boolean answear = false;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sqlStatement =
                    "        select exists(\n" +
                            "                SELECT FROM pg_tables WHERE schemaname = 'public' AND tablename  = " + "'" + tableName + "'" + " );";
            resultSet = statement.executeQuery(sqlStatement);
            while(resultSet.next()){
                answear = resultSet.getBoolean("exists");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet);
            close(statement);
            close(connection);
        }
        return answear;
    }

    public List<String> getTableColumns(String tableName){
        List<String> columns = new ArrayList<>();
        Connection connection = getConnection();;
        ResultSet resultSet = null;
        DatabaseMetaData metaData = null;
        Statement statement = null; ;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            ResultSetMetaData rsMetaData = resultSet.getMetaData();
            int count = rsMetaData.getColumnCount();
            for(int i = 1; i<=count; i++) {
               columns.add(rsMetaData.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(resultSet);
            close(connection);
        }
        return columns;
    }

}
