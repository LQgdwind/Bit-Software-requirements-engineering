package com.example.uml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        ImageView register=(ImageView)findViewById(R.id.register_button_image);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseOperate();//数据库操作
            }
        });
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
    private void databaseOperate()
    {
        UserInfoDatabase myDatabase=new UserInfoDatabase(this,"usersInfo.db",null,2);
        SQLiteDatabase databaseOp=myDatabase.getWritableDatabase();
        EditText account=(EditText) findViewById(R.id.editTextUserId);
        EditText password=(EditText) findViewById(R.id.editTextTextPassword);
        EditText name=(EditText) findViewById(R.id.editTextUsrname);
        EditText email=(EditText) findViewById(R.id.editTextTextEmailAddress);
        EditText phone=(EditText) findViewById(R.id.editTextPhone);
        CheckBox Male=(CheckBox) findViewById(R.id.checkBoxMale);
        CheckBox Female=(CheckBox) findViewById(R.id.checkBoxFemale);
        CheckBox Student=(CheckBox) findViewById(R.id.checkBoxStudent);
        CheckBox Teacher=(CheckBox) findViewById(R.id.checkBoxTeacher);
        CheckBox Admin=(CheckBox) findViewById(R.id.checkBoxAdmin);
        String accountText=account.getText().toString();
        String passwordText=password.getText().toString();
        String nameText=name.getText().toString();
        String emailText=email.getText().toString();
        String phoneText=phone.getText().toString();
        Boolean IsMale=Male.isChecked();
        Boolean IsFemale=Female.isChecked();
        Boolean IsStudent=Student.isChecked();
        Boolean IsTeacher=Teacher.isChecked();
        Boolean IsAdmin=Admin.isChecked();
        if(accountText.equals(""))
        {

            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入账户!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(passwordText.equals(""))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入密码!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(nameText.equals(""))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入昵称!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }if(emailText.equals(""))
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
        dialog.setTitle("无效注册");
        dialog.setMessage("请输入邮箱!");
        dialog.setCancelable(false);
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialog.show();
        return;
    }
        if(phoneText.equals(""))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入手机号!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(!IsMale && !IsFemale)
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入性别!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(!IsStudent && !IsTeacher && !IsAdmin)
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("请输入身份!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(!MyTool.isNumeric(accountText))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("账号只能由数字构成!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        if(!MyTool.isNumeric(phoneText))
        {
            AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
            dialog.setTitle("无效注册");
            dialog.setMessage("手机号只能由数字构成!");
            dialog.setCancelable(false);
            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialog.show();
            return;
        }
        String sexText;
        if(IsMale) sexText="male";
        else sexText="female";
        String statusText;
        if(IsStudent) statusText="student";
        else if(IsTeacher) statusText="teacher";
        else statusText="admin";
        databaseOp.execSQL("insert into usersInfo(account,password,userName,email,phone,sex,status) " +
                        "values (?,?,?,?,?,?,?)",
                new String[]{accountText,passwordText,nameText,emailText,phoneText,sexText,statusText});
        AlertDialog.Builder dialog=new AlertDialog.Builder(Register_Activity.this);
        dialog.setTitle("注册成功");
        dialog.setMessage("您已注册成功,请牢记账号密码！");
        dialog.setCancelable(false);
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(Register_Activity.this,Login_Register_Activity.class);
                startActivity(intent);
            }
        });
        dialog.show();
        myDatabase.close();
    }

}
