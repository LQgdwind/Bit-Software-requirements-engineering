package com.example.uml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SAActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sa);
        String[] userInfo=getIntent().getStringArrayExtra("userInfo");
        Log.e("am",userInfo[0]+" "+userInfo[1]+" "+userInfo[2]);
        findViewById(R.id.leaveRequest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(LeaveActivity.class,userInfo);
            }
        });
        findViewById(R.id.appointment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(ReservationActivity.class,userInfo);
            }
        });
    }
    public void Start(Class<?> activityClass, String[] userInfo){
        Intent intent=new Intent(this,activityClass);
        intent.putExtra("userInfo",userInfo);
        startActivity(intent);
    }
}