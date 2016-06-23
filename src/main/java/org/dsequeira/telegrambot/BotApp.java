package org.dsequeira.telegrambot;

import static spark.Spark.port;
import static spark.Spark.post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dsequeira.telegrambot.model.InlineQueryResultPhoto;
import org.dsequeira.telegrambot.model.KeyboardButton;
import org.dsequeira.telegrambot.model.Message;
import org.dsequeira.telegrambot.model.ReplyKeyboardMarkup;
import org.dsequeira.telegrambot.request.InlineQuery;
import org.dsequeira.telegrambot.request.InlineQueryRequest;
import org.dsequeira.telegrambot.request.MessageRequest;
import org.dsequeira.telegrambot.util.BotProperties;
import org.dsequeira.telegrambot.util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author daniel.sequeira
 */
public class BotApp {

    private static final Logger LOG = LoggerFactory.getLogger(BotApp.class);

    private static final String HTTP_TUNNEL_URL = BotProperties.getInstance().getProperty("HTTP_TUNNEL_URL");

    public static void main(final String[] args) throws IOException {

        BotService botService = new BotService(Constants.THE_ANNOYING_BOT);
        botService.setWebhook(HTTP_TUNNEL_URL);

        Document document = Jsoup.connect("http://www.getbynder.com/en/company/about-us/").get();
        Elements divs = document.getElementsByClass("team-picture");

        port(8080);
        post("/", "application/json", (request, response) -> {

            JsonObject jsonObject = new JsonParser().parse(request.body()).getAsJsonObject();

            if (jsonObject.get("inline_query") != null) {

                InlineQueryRequest inlineQueryRequest = new Gson().fromJson(request.body(), InlineQueryRequest.class);
                InlineQuery inlineQuery = inlineQueryRequest.getInlineQuery();

                List<InlineQueryResultPhoto> inlineQueryResultPhotos = new ArrayList<>();

                Elements imgs = null;

                if (inlineQuery.getQuery() == null || inlineQuery.getQuery().isEmpty()) {
                    imgs = divs.select("img");
                } else {
                    imgs = divs.select("img[alt*="+inlineQuery.getQuery()+"]");
                }

                if (imgs != null && imgs.size() > 0) {
                    for (Element img : imgs) {
                        String alt = img.attr("alt");
                        String src = img.attr("src");
                        String url = "http://www.getbynder.com".concat(src);

                        InlineQueryResultPhoto inlineQueryResultPhoto = new InlineQueryResultPhoto(url, url, alt, null);
                        inlineQueryResultPhotos.add(inlineQueryResultPhoto);
                    }
                }

                botService.answerInlineQuery(inlineQuery.getId(), new Gson().toJson(inlineQueryResultPhotos));

                LOG.info("Received inline query request: " + inlineQuery.toString());

            } else if (jsonObject.get("message") != null) {

                MessageRequest messageRequest = new Gson().fromJson(request.body(), MessageRequest.class);
                Message message = messageRequest.getMessage();

                LOG.info("Received request: " + message.toString());

                String query = message.getText();

                Elements imgs = divs.select("img[alt*="+query+"]");

                if (imgs != null && imgs.size() > 0) {

                    if (imgs.size() == 1) {
                        Element img = imgs.get(0);

                        String alt = img.attr("alt");
                        String src = img.attr("src");
                        String url = "http://www.getbynder.com".concat(src);

                        botService.sendMessage(message.getChat().getId(), "Markdown", "["+alt+"]("+url+")", null);
                    } else {
                        List<List<KeyboardButton>> listOfKeyboardButtons = new ArrayList<>();
                        for (Element img : imgs) {
                            String alt = img.attr("alt");
                            List<KeyboardButton> keyboardButton = Arrays.asList(new KeyboardButton(alt));
                            listOfKeyboardButtons.add(keyboardButton);
                        }

                        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(listOfKeyboardButtons, Boolean.TRUE);
                        botService.sendMessage(message.getChat().getId(), null, "Select Byndie...", new Gson().toJson(replyKeyboardMarkup));
                    }
                } else {
                    botService.sendMessage(message.getChat().getId(), "Markdown", "_No results for "+query+"_", null);
                }
            }
            return response.raw().getStatus();
        });
    }
}
