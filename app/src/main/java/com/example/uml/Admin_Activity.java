package com.example.uml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class Admin_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ImageView queryImage=(ImageView) findViewById(R.id.student);
        ImageView insertImage=(ImageView) findViewById(R.id.acdemic);
        ImageView deleteImage=(ImageView) findViewById(R.id.forum);
        queryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] res = new String[1];
                final EditText editText = new EditText(Admin_Activity.this);
                AlertDialog.Builder inputDialog = new AlertDialog.Builder(Admin_Activity.this);
                inputDialog.setTitle("请输入账号").setView(editText);
                inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                res[0] =editText.getText().toString();
                                Intent intent=new Intent(Admin_Activity.this,QueryActivity.class);
                                intent.putExtra("data",res[0]);
                                startActivity(intent);
                            }
                        }).show();
            }
        });
        insertImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Admin_Activity.this,InsertUserActivity.class);
                startActivity(intent);
            }
        });
        deleteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] res = new String[1];
                final EditText editText = new EditText(Admin_Activity.this);
                AlertDialog.Builder inputDialog = new AlertDialog.Builder(Admin_Activity.this);
                inputDialog.setTitle("请输入账号").setView(editText);
                inputDialog.setPositiveButton("确定", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String accountText=editText.getText().toString();
                        UserInfoDatabase myDatabase=new UserInfoDatabase(Admin_Activity.this,"usersInfo.db",null,2);
                        SQLiteDatabase databaseOp=myDatabase.getWritableDatabase();
                        Cursor cursor=databaseOp.rawQuery("select * from usersInfo",null);
                        cursor.moveToFirst();
                        do
                        {
                            //Log.e(TAG,Integer.toString(cursor.getColumnIndex("account")));
                            int accountNum = cursor.getInt(MyTool.myAbs(cursor.getColumnIndex("account")));
                            String accountJudge=Integer.toString(accountNum);
                            if(accountJudge.equals(accountText))
                            {
                                databaseOp.execSQL("delete from usersInfo where account = ?",new String[]{accountText});
                                AlertDialog.Builder dialog1=new AlertDialog.Builder(Admin_Activity.this);
                                dialog1.setTitle("操作成功");
                                dialog1.setMessage("成功删除用户"+accountText);
                                dialog1.setCancelable(false);
                                dialog1.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                dialog1.show();
                                return;
                            }
                        }while(cursor.moveToNext());
                        AlertDialog.Builder dialog1=new AlertDialog.Builder(Admin_Activity.this);
                        dialog1.setTitle("操作失败");
                        dialog1.setMessage("不存在用户!");
                        dialog1.setCancelable(false);
                        dialog1.setNegativeButton("返回", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {

                            }
                        });
                        dialog1.show();
                        myDatabase.close();
                    }
                }).show();
            }
        });
    }
}