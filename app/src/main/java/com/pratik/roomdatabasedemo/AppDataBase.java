package com.pratik.roomdatabasedemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserModel.class},version =  1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract UserDao userDao();

    private static AppDataBase appDatabase;


    private Context context;


    public static AppDataBase getInstance(Context context){

        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, Constants.User.USER_TABLE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static void destroyInstance() {
        appDatabase = null;
    }
}
