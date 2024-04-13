package org.example;

import org.example.Service.UserService;
import org.example.Service.impl.BotButtonService;
import org.example.Service.impl.UserServiceImpl;
import org.example.modul.BotState;
import org.example.modul.Role;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class CoinBot extends TelegramLongPollingBot {
    private final UserService userService = new UserServiceImpl() {
        @Override
        public User getUser(long chatId) {
            return null;
        }

        @Override
        public User create(User user) {
            return null;
        }
    };
    private final BotButtonService botButtonService = new BotButtonService();

    public CoinBot(String botToken) {
        super(botToken);
    }


    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            if (text.equals("/start") || text.equals("Back to main menu")) {
                User user = userService.getUser(chatId);


                if (user == null) {
                    user = userService.create(
                            new User(
                            )
                    );
                    System.out.println(user.toString());
                }

                SendMessage message = new SendMessage();
                message.setText("<b>\uD83D\uDC49 Choose one of the following: </b>");
                message.setParseMode(ParseMode.HTML);
                message.setChatId(user.getId());
                message.setReplyMarkup(botButtonService.mainMenu());

                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (text.equals("Asosiy menu ga qaytish")) {
                SendMessage message = new SendMessage();
                message.setChatId(chatId);
                message.setReplyMarkup(botButtonService.mainMenu());
                message.setText("<b>\uD83D\uDC49 Quyidagilardan birini tanlang</b>");
                message.setParseMode(ParseMode.HTML);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            } else if (text.equals("Asosiy menyuga qaytish 🔙")) {
                SendMessage message = new SendMessage();
                message.setText("Asosiy menyuga qaytildi");
                message.setChatId(chatId);
                message.setReplyMarkup(botButtonService.mainMenu());
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String getId() {
        return null;
    }

    public String getBotUsername() {
        return "@PdpCoinBot";
    }
}
