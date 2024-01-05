package com.waltermelon.election.repository;

import com.waltermelon.election.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository() {
        connection = DatabaseConnection.getConnection();
    }

    public User getUser() {
        String SELECT_USER_QUERY = "SELECT id, username, email FROM public.user";
        try (ResultSet resultSet = connection.prepareStatement(SELECT_USER_QUERY).executeQuery()) {
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                return new User(id, username, email);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
