package org.example.Service;

import org.example.modul.BotState;
import org.example.modul.User;

import java.util.List;

public interface UserService{
    User create(User user);
    User get(long chatId);

    User create(String chatId, BotState state);

    void update(String chatId, User user);

    User get(String chatId);

    void delete(String chatId);

    List<User> getAll();
    User update(long chatId, User user);
    User delete(long chatId);

    org.telegram.telegrambots.meta.api.objects.User getUser(long chatId);

    org.telegram.telegrambots.meta.api.objects.User create(org.telegram.telegrambots.meta.api.objects.User user);
}
