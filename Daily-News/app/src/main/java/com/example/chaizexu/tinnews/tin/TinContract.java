package com.example.chaizexu.tinnews.tin;

import com.example.chaizexu.tinnews.mvp.MvpContract;
import com.example.chaizexu.tinnews.retrofit.response.News;

import java.util.List;

/**
 * Created by chai on 10/8/18.
 */

public interface TinContract {


    interface View extends MvpContract.View<Presenter> {
        void showNewsCard(List<News> newsList);
        void onError();
    }

    interface Presenter extends MvpContract.Presenter<View, Model> {
        void showNewsCard(List<News> newsList);
        void saveFavoriteNews(News news);
        void onError();
    }

    interface Model extends MvpContract.Model<Presenter> {
        void fetchData(String country);
        void saveFavoriteNews(News news);
    }
}
