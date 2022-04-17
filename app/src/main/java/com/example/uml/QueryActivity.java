package com.example.uml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QueryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Intent preIntent=getIntent();
        String para=preIntent.getStringExtra("data");
        if(!para.equals(""))
        {
            this.QueryInit(para);
        }
        else
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(QueryActivity.this);
            dialog.setTitle("操作失败");
            dialog.setMessage("请输入账号");
            dialog.setCancelable(false);
            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i)
                {
                    Intent intent=new Intent(QueryActivity.this,Admin_Activity.class);
                    startActivity(intent);
                    finish();
                }
            });
            dialog.show();
        }
        ImageView register = (ImageView) findViewById(R.id.register_button_image);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(QueryActivity.this,Admin_Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void QueryInit(String accountText)
    {
        UserInfoDatabase myDatabase = new UserInfoDatabase(this, "usersInfo.db", null, 2);
        SQLiteDatabase databaseOp = myDatabase.getWritableDatabase();
        Cursor cursor = databaseOp.rawQuery("select * from usersInfo", null);
        cursor.moveToFirst();
        do {
            //Log.e(TAG,Integer.toString(cursor.getColumnIndex("account")));
            int accountNum = cursor.getInt(MyTool.myAbs(cursor.getColumnIndex("account")));
            String accountJudge = Integer.toString(accountNum);
            if (accountJudge.equals(accountText)) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(QueryActivity.this);
                dialog.setTitle("操作成功");
                dialog.setMessage("用户查询成功");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String passwordText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("password")));
                        String userNameText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("userName")));
                        String emailText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("email")));
                        String phoneText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("phone")));
                        String sexText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("sex")));
                        String statusText=cursor.getString(MyTool.myAbs(cursor.getColumnIndex("status")));
                        TextView account=(TextView) findViewById(R.id.editTextUserId);
                        TextView password=(TextView) findViewById(R.id.editTextTextPassword);
                        TextView name=(TextView) findViewById(R.id.editTextUsrname);
                        TextView email=(TextView) findViewById(R.id.editTextTextEmailAddress);
                        TextView phone=(TextView) findViewById(R.id.editTextPhone);
                        TextView sex=(TextView) findViewById(R.id.editTextSex);
                        TextView status=(TextView) findViewById(R.id.editTextStatus);
                        account.setText(accountText);
                        password.setText(passwordText);
                        name.setText(userNameText);
                        email.setText(emailText);
                        phone.setText(phoneText);
                        sex.setText(sexText);
                        status.setText(statusText);
                    }
                });
                dialog.show();
                return;
            }
        } while (cursor.moveToNext());
        AlertDialog.Builder dialog = new AlertDialog.Builder(QueryActivity.this);
        dialog.setTitle("操作失败");
        dialog.setMessage("不存在该用户!");
        dialog.setCancelable(false);
        dialog.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                Intent intent=new Intent(QueryActivity.this,Admin_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        dialog.show();
        myDatabase.close();
    }
}
