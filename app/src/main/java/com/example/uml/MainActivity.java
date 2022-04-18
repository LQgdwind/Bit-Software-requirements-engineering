package com.example.uml;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] userInfo=getIntent().getStringArrayExtra("userInfo");
        Log.e("userInfo","from_main_"+userInfo[0]+userInfo[1]+userInfo[2]);
        setContentView(R.layout.activity_main);
        findViewById(R.id.acdemic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Start(AMActivity.class,userInfo);
            }
        });
    }

    public void Start(Class<?> activityClass, String[] userInfo){
        Intent intent=new Intent(this,activityClass);
        intent.putExtra("userInfo",userInfo);
        startActivity(intent);
    }
}