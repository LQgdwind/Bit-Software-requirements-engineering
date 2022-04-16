package com.example.uml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login_Register_Activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        this.goToRegisterActivity();//跳转注册活动
    }
    private void goToRegisterActivity()//跳转注册活动
    {
        TextView register_connect=(TextView) findViewById(R.id.userid_text3);
        register_connect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Register_Activity.this,Register_Activity.class);
                startActivity(intent);
            }
        });
    }

}