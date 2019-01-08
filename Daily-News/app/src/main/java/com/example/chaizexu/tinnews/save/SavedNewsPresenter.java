package com.example.chaizexu.tinnews.save;

import com.example.chaizexu.tinnews.retrofit.response.News;

import java.util.List;

/**
 * Created by chai on 10/9/18.
 */

public class SavedNewsPresenter implements SavedNewsContract.Presenter {
    private final SavedNewsContract.Model model;
    private SavedNewsContract.View view;

    public SavedNewsPresenter() {
        model = new SavedNewsModel();
        model.setPresenter(this);
    }
    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onViewAttached(SavedNewsContract.View view) {
        this.view = view;
        this.model.fetchData();
    }

    @Override
    public void onViewDetached() {
        this.view = null;
    }

    @Override
    public void loadSavedNews(List<News> newsList) {
        if (view != null) {
            view.loadSavedNews(newsList);
        }
    }
}
