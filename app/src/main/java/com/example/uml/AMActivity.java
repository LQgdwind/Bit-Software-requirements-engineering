package com.example.uml;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am);
        String[] userInfo=getIntent().getStringArrayExtra("userInfo");
         Log.e("am",userInfo[0]+" "+userInfo[1]+" "+userInfo[2]);
        findViewById(R.id.lexue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(LexueActivity.class,userInfo);
            }
        });
        findViewById(R.id.yanhe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(YanheActivity.class,userInfo);
            }
        });
        findViewById(R.id.exam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(ExamActivity.class,userInfo);
            }
        });
        findViewById(R.id.shedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(SheduleActivity.class,userInfo);
            }
        });
    }
    public void Start(Class<?> activityClass, String[] userInfo){
        Intent intent=new Intent(this,activityClass);
        intent.putExtra("userInfo",userInfo);
        startActivity(intent);
    }
}