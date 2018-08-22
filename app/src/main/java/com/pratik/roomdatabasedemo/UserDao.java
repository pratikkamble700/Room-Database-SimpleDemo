package com.pratik.roomdatabasedemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.ArrayList;

@Dao
public interface UserDao {

    @Query("SELECT * FROM "+Constants.User.USER_TABLE_NAME)
    ArrayList<UserModel> getAllUsers();

    @Insert
    void insertAllUser(UserModel... users);

    @Delete
    int deleteUser(UserModel user);

}
