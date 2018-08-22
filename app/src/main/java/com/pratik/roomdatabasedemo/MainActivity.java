package com.pratik.roomdatabasedemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, onClickListnerCallBack {

    FloatingActionButton fabAddUser;
    UserAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;

    ArrayList<UserModel> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAddUser = (FloatingActionButton) findViewById(R.id.fabAddUser);
        fabAddUser.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager( layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
//        users = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            users.add(new UserModel("Pratik  : "+i,123456789,"test@test.com"));
//        }

       final AppDataBase db = AppDataBase.getInstance(MainActivity.this);
        users = db.userDao().getAllUsers();

        adapter = new UserAdapter(users,MainActivity.this,this);
                recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAddUser:
                Intent intent = new Intent(MainActivity.this, CreateUserActivity.class);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onclick(int possition) {
        AppDataBase.getInstance(MainActivity.this).userDao().deleteUser(users.get(possition));
        adapter.notifyDataSetChanged();
    }
}
