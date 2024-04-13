package org.example.repositories;

import org.example.util.CustomDataSource;
import org.example.modul.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository {
    private final String findAllUsers = "SELECT * FROM user";
    private final String findById = "SELECT * FROM user WHERE id = ?";
    private final String updateById = "UPDATE user SET fullname=?, role=?, bot_state=?, grade = ? WHERE id=?";
    private final String insertUser=
            "INSERT INTO user(chat_id, full_name, role, bot_state, grade) VALUES(?,?,?,?,?)";

    public List<User> findAllUser(){
        List<User> users = new ArrayList<>();
        try(
                Connection connection = CustomDataSource.getInstance().getConnection();
                Statement statement = connection.createStatement();
        ){
            ResultSet resultSet = statement.executeQuery(findAllUsers);
            while (resultSet.next()){
                User user = new User();
                user.setChatId(resultSet.getLong("chat_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                user.setGrade(String.valueOf(resultSet.getInt("grade")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
    public User getUserById(long id){
        User user = new User();
        try (
                Connection connection = CustomDataSource.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(findById, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setObject(1,id);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()){
                user.setChatId(resultSet.getLong("chat_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole(Role.valueOf(resultSet.getString("role")));
                user.setBotState((BotState) resultSet.getObject("bot_state"));
                user.setGrade(String.valueOf(resultSet.getInt("grade")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public boolean createUser(User user){
        try (
                Connection connection = CustomDataSource.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS)
        ){
            ps.setObject(1, user.getChatId());
            ps.setObject(2, user.getFullName());
            ps.setObject(3, user.getRole());
            ps.setObject(4, user.getBotState());
            ps.setObject(5, user.getGrade());
            return ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getFindAllUsers() {
        return findAllUsers;
    }

    public String getFindById() {
        return findById;
    }

    public String getUpdateById() {
        return updateById;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public boolean getUpdateById(Long id, User user){
        try (
                Connection connection = CustomDataSource.getInstance().getConnection();
                PreparedStatement ps = connection.prepareStatement(updateById)
        ){
            ps.setObject(1, user.getFullName());
            ps.setObject(2, user.getRole());
            ps.setObject(3, user.getBotState());
            ps.setObject(4, user.getGrade());
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract Student create(Student student);

    public abstract Student getById(long id);

    public abstract List<Teacher> getAll();

    public abstract Student update(long id, Student updatedStudent);

    public abstract User delete(long id);

    public void create(String chatId, BotState state) {

    }

    public User getById(String chatId) {
        return null;
    }
}
