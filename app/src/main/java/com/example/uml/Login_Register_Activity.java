package com.example.uml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Register_Activity extends AppCompatActivity
{
    private static final String TAG="Login_Register_Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        this.goToRegisterActivity();//跳转注册活动
        ImageView login=(ImageView) findViewById(R.id.register_button_image);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginJudge();
            }
        });
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
    private void loginJudge()
    {
        //Toast.makeText(Login_Register_Activity.this,"ok",Toast.LENGTH_LONG);
        EditText account=(EditText) findViewById(R.id.editTextUserId);
        EditText password=(EditText) findViewById(R.id.editTextTextPassword);
        String accountText=account.getText().toString();
        String passwordText=password.getText().toString();
        UserInfoDatabase myDatabase=new UserInfoDatabase(this,"usersInfo.db",null,2);
        SQLiteDatabase databaseOp=myDatabase.getWritableDatabase();
        Cursor cursor=databaseOp.rawQuery("select * from usersInfo",null);
        cursor.moveToFirst();
        do
        {
            //Log.e(TAG,Integer.toString(cursor.getColumnIndex("account")));
            int accountNum = cursor.getInt(MyTool.myAbs(cursor.getColumnIndex("account")));
            String accountJudge=Integer.toString(accountNum);
            String userName=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("userName")));
            String passwordJudge=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("password")));
            if(accountJudge.equals(accountText) && passwordJudge.equals(passwordText))
            {
                AlertDialog.Builder dialog=new AlertDialog.Builder(Login_Register_Activity.this);
                dialog.setTitle("登录成功");
                dialog.setMessage("欢迎回来,"+userName);
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
                return;
            }
        }while(cursor.moveToNext());
        AlertDialog.Builder dialog=new AlertDialog.Builder(Login_Register_Activity.this);
        dialog.setTitle("登录失败");
        dialog.setMessage("账号密码错误!");
        dialog.setCancelable(false);
        dialog.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialog.show();
        myDatabase.close();
    }
}