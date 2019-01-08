package com.example.chaizexu.tinnews.retrofit;

/**
 * Created by chai on 10/6/18.
 */

import com.example.chaizexu.tinnews.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsRequestApi {
    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);
}

