package com.example.chaizexu.tinnews.retrofit.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chai on 10/6/18.
 */

public class BaseResponse {
    public String status;
    public int totalResults;
    @SerializedName("articles")
    public List<News> articles;
}
