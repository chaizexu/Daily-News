package com.example.chaizexu.tinnews.tin;

import com.example.chaizexu.tinnews.profile.CountryEvent;
import com.example.chaizexu.tinnews.retrofit.response.News;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by chai on 10/8/18.
 */

public class TinPresenter implements TinContract.Presenter {


    private TinContract.View view;
    private TinContract.Model model;

    public TinPresenter() {
        this.model = new TinModel();
        //link the model with presenter
        this.model.setPresenter(this);
    }

    @Override
    public void onCreate() {
        EventBus.getDefault().register(this);
    }


    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CountryEvent countryEvent) {
        if (this.view != null) {
            //7.6
            this.model.fetchData(countryEvent.country);
        }
    }


    @Override
    public void onViewAttached(TinContract.View view) {

        this.view = view;
        this.model.fetchData("us");
    }

    @Override
    public void onViewDetached() {

        this.view = null;
    }

    @Override
    public void showNewsCard(List<News> newsList) {
        if (this.view != null) {
            view.showNewsCard(newsList);
        }
    }

    @Override
    public void saveFavoriteNews(News news) {
        model.saveFavoriteNews(news);
    }

    @Override
    public void onError() {
        if (view != null) {
            view.onError();
        }
    }

}


