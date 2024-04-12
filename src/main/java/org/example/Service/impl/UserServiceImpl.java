package org.example.Service.impl;

import org.example.Service.UserService;
import org.example.modul.BotState;
import org.example.modul.User;
import org.example.repostriys.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return (User) userRepository.create(user);
    }

    @Override
    public User get(long chatId) {
        return userRepository.getUserById(chatId);
    }

    @Override
    public User create(String chatId, BotState state) {
        User user = new User();
        user.setChatId(Long.parseLong(chatId));
        user.setBotState(state);
        return (User) userRepository.create(user);
    }

    @Override
    public void update(String chatId, User user) {
        userRepository.getUpdateById(Long.parseLong(chatId), user);
    }

    @Override
    public User get(String chatId) {
        return userRepository.getUserById(Long.parseLong(chatId));
    }

    @Override
    public void delete(String chatId) {
        userRepository.delete(Long.parseLong(chatId));
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAllUser();
    }

    @Override
    public User update(long chatId, User user) {
        return (User) userRepository.update(chatId, user);
    }

    @Override
    public User delete(long chatId) {
        return userRepository.delete(chatId);
    }
}
