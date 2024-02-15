package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {

    public UserDaoJDBCImpl() {

    }

    @Override
    public void createUsersTable() {

        String createUserTable = "CREATE TABLE IF NOT EXISTS users (" +

                "  id BIGINT NOT NULL AUTO_INCREMENT," +

                "  name VARCHAR(50)," +

                "  lastName VARCHAR(50)," +

                "  age TINYINT," +

                "  PRIMARY KEY (id));";

        try (Connection connection = Util.getNewConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(createUserTable);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {

        String deleteUsersTable = "DROP TABLE IF EXISTS users";

        try (Connection connection = Util.getNewConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(deleteUsersTable);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        String saveUser = "INSERT INTO users(name, lastName, age) VALUES(?, ?, ?)";

        try (Connection connection = Util.getNewConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveUser)) {
            preparedStatement.setString(1,name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3,age);
            preparedStatement.executeUpdate();
            System.out.printf("User с именем — %s добавлен в базу данных", name);
            System.out.println();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public void removeUserById(long id) {

        String removeUser = "DELETE FROM users WHERE id = ?";

        try (Connection connection = Util.getNewConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(removeUser)) {
            preparedStatement.setInt(1, (int) id);
            preparedStatement.executeUpdate(removeUser);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        List<User> allUsers = new ArrayList<>();
        String getUsers = "SELECT * FROM users";

        try (Connection connection = Util.getNewConnection();
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(getUsers)) {

            while (result.next()) {
                User user = new User();
                user.setId(result.getLong("id"));
                user.setName(result.getString("name"));
                user.setLastName(result.getString("lastName"));
                user.setAge(result.getByte("age"));
                allUsers.add(user);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return allUsers;
    }

    @Override
    public void cleanUsersTable() {

        String cleanUsersTable = "TRUNCATE TABLE users";

        try (Connection connection = Util.getNewConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(cleanUsersTable);
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
