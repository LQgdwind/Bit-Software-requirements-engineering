package com.example.uml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class Register_Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.initCheckSexBox();//初始化性别单选框
        this.initCheckStatusBox();//初始化身份单选框
        this.goToLoginActivity();//跳转登录活动
    }
    private void goToLoginActivity()//跳转登录活动
    {
        TextView register_connect=(TextView) findViewById(R.id.userid_text3);
        register_connect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Register_Activity.this,Login_Register_Activity.class);
                startActivity(intent);
            }
        });
    }
    private void initCheckSexBox()
    {
        CheckBox male = (CheckBox) findViewById(R.id.checkBoxMale);
        CheckBox female = (CheckBox) findViewById(R.id.checkBoxFemale);
        //监听选中取消事件
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    male.setChecked(true);
                    female.setChecked(false);
                }else {
                    male.setChecked(false);
                }
            }
        });
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    female.setChecked(true);
                    male.setChecked(false);
                }else {
                    female.setChecked(false);
                }
            }
        });
    }
    private void initCheckStatusBox()
    {
        CheckBox student = (CheckBox) findViewById(R.id.checkBoxStudent);
        CheckBox teacher = (CheckBox) findViewById(R.id.checkBoxTeacher);
        CheckBox admin = (CheckBox) findViewById(R.id.checkBoxAdmin);
        //监听选中取消事件
        student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    student.setChecked(true);
                    teacher.setChecked(false);
                    admin.setChecked(false);
                }else {
                    student.setChecked(false);
                }
            }
        });
        teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    teacher.setChecked(true);
                    student.setChecked(false);
                    admin.setChecked(false);
                }else {
                    teacher.setChecked(false);
                }
            }
        });
        admin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    admin.setChecked(true);
                    student.setChecked(false);
                    teacher.setChecked(false);
                }else {
                    admin.setChecked(false);
                }
            }
        });
    }

}
