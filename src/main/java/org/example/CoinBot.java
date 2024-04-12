package org.example;

import org.example.Service.impl.BotButtonService;
import org.example.Service.impl.UserServiceImpl;
import org.example.modul.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.singletonList;

public class CoinBot extends TelegramLongPollingBot {
    private final UserServiceImpl userService = new UserServiceImpl() {
        @Override
        public User create(User user) {
            return null;
        }

        @Override
        public User get(long chatId) {
            return null;
        }

        @Override
        public User update(long chatId, User user) {
            return null;
        }

        @Override
        public User delete(long chatId) {
            return null;
        }
    };
    private final BotButtonService botButtonService = new BotButtonService();

    private static int count = 1;

    public CoinBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            if(text.equals("/start")) {

            } else {

            }
        } else if (update.hasCallbackQuery()) {

        }
    }



    @Override
    public String getBotUsername() {
        return "@PdpCointBot";
    }

    public UserServiceImpl getUserService() {
        return userService;
    }
}
