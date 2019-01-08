package com.example.chaizexu.tinnews.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.chaizexu.tinnews.retrofit.response.News;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Created by chai on 10/8/18.
 */

@Dao
public interface NewsDao {

    @Insert
    void insertNews(News news);

    @Query("SELECT * FROM news")
    Flowable<List<News>> getAll();

    @Query("DELETE FROM news")
    void deleteAllNews();
}

