package com.waltermelon.election.repository;

import com.waltermelon.election.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {
    private final Connection connection;

    public UserRepository() {
        connection = DatabaseConnection.getConnection();
    }

    public User getUser(Integer id) {
        String sql = "SELECT id, username, email FROM public.user where id = ?";
        return executeQuerySQL(sql, id);
    }

    public boolean save(User user) {
        String sql = "INSERT INTO public.user (id, username, email) VALUES (?, ?, ?)";
        return executeUpdateSQL(sql, user);
    }

    private User executeQuerySQL(String sql, Integer userId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("email");
                return new User(id, username, email);
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean executeUpdateSQL(String sql, User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getEmail());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return Boolean.FALSE;
    }
}
