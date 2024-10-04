package model.repositories;

import model.models.enums.UserType;
import model.models.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private DatabaseManagement databaseManagement = DatabaseManagement.getInstance();
    public UserRepository(){
    }

    public List<Users> getAllUsers(){
        List<Users> users = new ArrayList<>();
        String sqlStatement = "SELECT * FROM users";
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                UserType userType = UserType.valueOf(resultSet.getString("user_type"));
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Boolean isEnabled = resultSet.getBoolean("is_enabled");
                users.add(new Users(id, email, password, phone, address, userType, isEnabled));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return users;
    }

    public Optional<Users> getUserById(int id){
        Users user = null;
        String sqlStatement = "SELECT * FROM users WHERE id = '" + id + "'";
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                UserType userType = UserType.valueOf(resultSet.getString("user_type"));
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Boolean isEnabled = resultSet.getBoolean("is_enabled");
                user = new Users(id, email, password, phone, address, userType, isEnabled);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return Optional.ofNullable(user);
    }

    public Optional<Users> getUserByEmail(String email){
        Users user = null;
        String sqlStatement = "SELECT * FROM users WHERE email = '" + email + "'";
        Connection connection = databaseManagement.getConnection();
        Statement selectStatement = null;
        ResultSet resultSet = null;
        try {
            selectStatement = connection.createStatement();
            resultSet = selectStatement.executeQuery(sqlStatement);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String password = resultSet.getString("password");
                UserType userType = UserType.valueOf(resultSet.getString("user_type"));
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                Boolean isEnabled = resultSet.getBoolean("is_enabled");
                user = new Users(id, email, password, phone, address, userType, isEnabled);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            databaseManagement.close(resultSet);
            databaseManagement.close(selectStatement);
            databaseManagement.close(connection);
        }
        return Optional.ofNullable(user);
    }

    public void addUser(Users user) {
        String sqlStatement = "INSERT INTO users(email, password, phone, address, user_type, is_enabled) VALUES" + user.toQueryString();
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

    public void updateUser(int id, Users updatedUser) {
        String sqlStatement = "UPDATE users SET " + updatedUser.toUpdateQueryString() + " WHERE id=" + id;
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

    public void deleteUser(int id) {
        String sqlStatement = "DELETE FROM users WHERE id=" + id;
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

    public void deleteUser(String email) {
        String sqlStatement = "DELETE FROM users WHERE email=" + "'" +email + "'";
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
}
