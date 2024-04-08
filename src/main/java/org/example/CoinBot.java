package org.example;

import org.example.Service.impl.BotButtonService;
import org.example.Service.impl.StudentServiceImpl;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class CoinBot extends TelegramLongPollingBot {
    private final StudentServiceImpl userService = new StudentServiceImpl ();
    private final BotButtonService botButtonService = new BotButtonService ();

    private static int count = 1;

    public CoinBot(String botToken) {
        super(botToken);
    }


    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage () && update.getMessage ().hasText ()){
            long chatId = update.getMessage ().getChatId ();
            String text = update.getMessage ().getText ();

            if(text.equals ("/start")){

            }else {

            }
        } else if (update.hasCallbackQuery ()) {

        }
    }

    @Override
    public String getBotUsername() {
        return "@pdpcoinbot";
    }


    public StudentServiceImpl getUserService() {
        return userService;
    }
}
