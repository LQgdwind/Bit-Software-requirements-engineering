package com.example.uml;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserInfoDatabase extends SQLiteOpenHelper
{
    private Context userContext;
    public UserInfoDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
        userContext=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table user(" +
                "userKey integer primary key autoincrement," +
                "userId integer," +
                "password text," +
                "userName text," +
                "email text," +
                "phone integer," +
                "sex text," +
                "status text)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }

}
