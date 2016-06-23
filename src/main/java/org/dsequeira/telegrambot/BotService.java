package org.dsequeira.telegrambot;

import java.io.IOException;

import org.dsequeira.telegrambot.api.BotApi;
import org.dsequeira.telegrambot.response.MessageResponse;
import org.dsequeira.telegrambot.response.OkResponse;
import org.dsequeira.telegrambot.response.UpdatesResponse;
import org.dsequeira.telegrambot.response.UserResponse;
import org.dsequeira.telegrambot.response.WebhookResponse;
import org.dsequeira.telegrambot.util.BotProperties;
import org.dsequeira.telegrambot.util.Constants;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author daniel.sequeira
 */
public class BotService {

    private BotApi botApi;

    public BotService(final String botName) {

        String botToken = BotProperties.getInstance().getProperty(botName);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL.concat(botToken)).addConverterFactory(GsonConverterFactory.create()).build();
        botApi = retrofit.create(BotApi.class);
    }

    public Response<UserResponse> getMe() throws IOException {
        return botApi.getMe().execute();
    }

    public Response<MessageResponse> sendMessage(final Integer id, final String parseMode, final String message, final String replyMarkup) throws IOException {
        return botApi.sendMessage(id, parseMode, message, replyMarkup).execute();
    }

    public Response<UpdatesResponse> getUpdates(final Integer offset, final Integer limit) throws IOException {
        return botApi.getUpdates(offset, limit, null).execute();
    }

    public Response<WebhookResponse> setWebhook(final String url) throws IOException {
        return botApi.setWebhook(url).execute();
    }

    public Response<OkResponse> answerInlineQuery(final String inlineQueryId, final String results) throws IOException {
        return botApi.answerInlineQuery(inlineQueryId, results).execute();
    }
}
