package com.pratik.roomdatabasedemo;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = Constants.User.USER_TABLE_NAME)
public class UserModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.User.COLUM_UID)
    private int id;

    @ColumnInfo(name = Constants.User.COLUM_NAME)
    private String name;

    @ColumnInfo(name = Constants.User.COLUM_NUMBER)
    private int number;

    @ColumnInfo(name = Constants.User.COLUM_EMAIL)
    private String email;

    public UserModel(String name, int number, String email) {
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
