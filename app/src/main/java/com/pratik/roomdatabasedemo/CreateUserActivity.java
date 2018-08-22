package com.pratik.roomdatabasedemo;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateUserActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnRegister, btnDelete;
    EditText etEmail, etNumber, etName;
    AppDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        etName = (EditText) findViewById(R.id.etName);
        etNumber = (EditText) findViewById(R.id.etNumber);
        etEmail = (EditText) findViewById(R.id.etEmail);


        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                // todo insert record to the DataBase
                UserModel temp = new UserModel(etName.getText().toString(),Integer.parseInt(etNumber.getText().toString()),etEmail.getText().toString());
                UserDao userDao =(UserDao) AppDataBase.getInstance(CreateUserActivity.this).userDao();
                userDao.insertAllUser(temp);
                Intent intent = new Intent(CreateUserActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.btnDelete:
                // todo delete record from dataBase
                Toast.makeText(CreateUserActivity.this,"Coming Soon !!!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
