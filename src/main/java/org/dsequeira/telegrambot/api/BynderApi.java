package org.dsequeira.telegrambot.api;

import java.util.List;

import org.dsequeira.telegrambot.model.MediaAsset;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * @author daniel.sequeira
 */
public interface BynderApi {

    @GET("media/")
    Call<List<MediaAsset>> retrieveMedia(@Query("type") String type, @Query("keyword") String keyword, @Query("tags") String tags, @Query("propertyOptionId") String propertyOptionId);
}
