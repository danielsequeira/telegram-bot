package org.dsequeira.telegrambot.util;

import java.util.concurrent.TimeUnit;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/**
 *
 * @author daniel.sequeira
 */
public final class Utils {

    // separators
    public static final String STR_AND = "&";
    public static final String STR_COMMA = ",";
    public static final String STR_EQUALS = "=";
    public static final String STR_SPACE = " ";

    private Utils() {
        // prevent instantiation
    }

    public static <T> T createApiService(final Class<T> apiClass) {

        String tokenKey = BynderProperties.getInstance().getProperty("ACCESS_TOKEN_KEY");
        String tokenSecret = BynderProperties.getInstance().getProperty("ACCESS_TOKEN_SECRET");

        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(BynderProperties.getInstance().getProperty("CONSUMER_KEY"), BynderProperties.getInstance().getProperty("CONSUMER_SECRET"));
        consumer.setTokenWithSecret(tokenKey, tokenSecret);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.interceptors().clear();
        httpClient.addInterceptor(new SigningInterceptor(consumer));

        // Increase timeout
        httpClient.readTimeout(30, TimeUnit.SECONDS);
        httpClient.connectTimeout(30, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();

        Builder retrofitBuilder = new Builder().baseUrl(Constants.BYNDER_BASE_URL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapter(Boolean.class, new BooleanTypeAdapter()).create()));

        Retrofit retrofitBynderApi = retrofitBuilder.client(client).build();

        return retrofitBynderApi.create(apiClass);
    }
}
