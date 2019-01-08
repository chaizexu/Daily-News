package com.example.chaizexu.tinnews.profile;

import android.annotation.SuppressLint;

import com.example.chaizexu.tinnews.TinApplication;
import com.example.chaizexu.tinnews.database.AppDatabase;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chai on 10/11/18.
 */

public class ProfileModel implements ProfileContract.Model {

    private ProfileContract.Presenter presenter;
    private AppDatabase db = TinApplication.getDataBase();

    @Override
    public void setPresenter(ProfileContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @SuppressLint("CheckResult")
    @Override
    public void deleteAllNewsCache() {
        Completable.fromAction(() -> db.newsDao().deleteAllNews()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(() -> {
            presenter.onCacheCleared();
        }, error -> {

        });
    }


    @Override
    public void setDefaultCountry(String country) {
        EventBus.getDefault().post(new CountryEvent(country));
    }

}

