package org.dsequeira.telegrambot.api;

import org.dsequeira.telegrambot.response.MessageResponse;
import org.dsequeira.telegrambot.response.OkResponse;
import org.dsequeira.telegrambot.response.UpdatesResponse;
import org.dsequeira.telegrambot.response.UserResponse;
import org.dsequeira.telegrambot.response.WebhookResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 *
 * @author daniel.sequeira
 */
public interface BotApi {

    @GET("getMe")
    Call<UserResponse> getMe();

    @FormUrlEncoded
    @POST("sendMessage")
    Call<MessageResponse> sendMessage(@Field("chat_id") Integer chatId, @Field("parse_mode") String parseMode, @Field("text") String text, @Field("reply_markup") String replyMarkup);

    @GET("getUpdates")
    Call<UpdatesResponse> getUpdates(@Query("offset") Integer offset, @Query("limit") Integer limit, @Query("timeout") Integer timeout);

    @FormUrlEncoded
    @POST("setWebhook")
    Call<WebhookResponse> setWebhook(@Field("url") String url);

    @FormUrlEncoded
    @POST("answerInlineQuery")
    Call<OkResponse> answerInlineQuery(@Field("inline_query_id") String inlineQueryId, @Field("results") String results);
}
