package com.example.helloworld.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDBOpenHelper extends SQLiteOpenHelper {
    private static final String TAG="jayclin";

    public MyDBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, version);
    }

    @Override
    //数据库第一次创建时调用
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG,"MyDBOpenHelper:执行了onCreate");
        db.execSQL("CREATE TABLE person (personid INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(20))");
    }

    //软件版本号发生改变时调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG,"MyDBOpenHelper:执行了onUpgrade");
        db.execSQL("ALTER TABLE person ADD phone VARCHAR(12) not null");
    }
}
