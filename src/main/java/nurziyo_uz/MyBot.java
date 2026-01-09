package nurziyo_uz;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    MyBotService myBotService = new MyBotService();
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()&& update.getMessage().hasText()){
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

//            foydalanuvchidan ma'lumot olish

            String firstName = update.getMessage().getChat().getFirstName();
            String lastName = update.getMessage().getChat().getLastName();

            System.out.println("Firstname:" + firstName + "\nLastname:" +lastName+
                    "\nText:" + text + "\nChatId:" + chatId);

//            Replu buttoni chaqirish

            if (text.equals("/start")){
                try {
                    execute(myBotService.start(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }


            if (text.equals("Menular")){
                try {
                    execute(myBotService.inlene(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }




            

        }
    }

    @Override
    public String getBotUsername() {
        return "nurziyosheyxBot";
    }

    @Override
    public String getBotToken() {
        return "8342620478:AAETYZZrMGFyh9_OMZlNqPGozG3G3xQUK8s";
    }
}
