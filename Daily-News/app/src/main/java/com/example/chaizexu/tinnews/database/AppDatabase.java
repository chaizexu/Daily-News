package com.example.chaizexu.tinnews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.chaizexu.tinnews.retrofit.response.News;

/**
 * Created by chai on 10/8/18.
 */
@Database(entities = {News.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();
}
