package org.dsequeira.telegrambot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.dsequeira.telegrambot.BotService;
import org.dsequeira.telegrambot.response.MessageResponse;
import org.dsequeira.telegrambot.response.UserResponse;
import org.dsequeira.telegrambot.response.WebhookResponse;
import org.dsequeira.telegrambot.util.BotProperties;
import org.dsequeira.telegrambot.util.Constants;
import org.junit.Before;
import org.junit.Test;

import retrofit2.Response;

/**
 *
 * @author daniel.sequeira
 */
public class BotServiceIT {

    private final String HTTP_TUNNEL_URL = BotProperties.getInstance().getProperty("HTTP_TUNNEL_URL");
    private final String CHAT_ID = BotProperties.getInstance().getProperty("CHAT_ID");

    private BotService botService;
    @Before
    public void setUp() throws Exception {
        botService = new BotService(Constants.THE_ANNOYING_BOT);
    }

    @Test
    public void getMeTest() throws IOException {
        Response<UserResponse> userResponse = botService.getMe();
        assertNotNull(userResponse);
        assertTrue(userResponse.body().isOk());
    }

    @Test
    public void setWebhookTest() throws IOException {
        Response<WebhookResponse> webhookResponse = botService.setWebhook(null);
        assertNotNull(webhookResponse);
        assertTrue(webhookResponse.body().isOk());

        webhookResponse = botService.setWebhook(HTTP_TUNNEL_URL);
        assertNotNull(webhookResponse);
        assertTrue(webhookResponse.body().isOk());
    }

    @Test
    public void sendMessageTest() throws IOException {
        Response<MessageResponse> messageResponse = botService.sendMessage(Integer.parseInt(CHAT_ID), null, Constants.HELLO_WORLD, null);
        assertNotNull(messageResponse);
        assertTrue(messageResponse.body().isOk());
    }
}
