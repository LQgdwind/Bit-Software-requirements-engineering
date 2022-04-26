
package com.example.uml;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.example.uml.Fragments.Fragments_All;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CFActivity extends AppCompatActivity {

    //ViewPager2 Components
    ViewPager2 mViewPager;

    // TabLayout Components
    private FragmentAdapter mFragmentAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cf);
        //Initializing
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mViewPager = (ViewPager2) findViewById(R.id.viewPager);

        //Binding TabLayout and ViewPager2
        FragmentManager fm = getSupportFragmentManager();

        mViewPager.setAdapter(mFragmentAdapter);

        //Set TabLayout
        //binding ViewPager2 and Fragments
        tabLayout.addTab(tabLayout.newTab().setText("全部"));
        tabLayout.addTab(tabLayout.newTab().setText("表白"));
        tabLayout.addTab(tabLayout.newTab().setText("吐槽"));
        tabLayout.addTab(tabLayout.newTab().setText("知乎"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        mFragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        mViewPager.setAdapter(mFragmentAdapter);

        //set publish button
        Button publishButton = (Button) findViewById(R.id.cf_publish);
        String[] userinfo = getIntent().getStringArrayExtra("userInfo");

        publishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String commentInfoText = "  #4 " + userinfo[2] + "|普通                                                                         刚刚";
                TextView commentInfo = (TextView) findViewById(R.id.AllLayoutWindow1_top);
                commentInfo.setText(commentInfoText);

                EditText input = (EditText) findViewById(R.id.cfEditText);
                String text = "        " + input.getText().toString();
                TextView mainText = (TextView) findViewById(R.id.AllLayoutWindow1_main);
                mainText.setText(text);

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.AllLayoutWindow1);
                relativeLayout.setVisibility(View.VISIBLE);

                input.setText("");

                AlertDialog.Builder dialog=new AlertDialog.Builder(CFActivity.this);
                dialog.setTitle("BIT_BBS");
                dialog.setMessage("发表成功!");
                dialog.setCancelable(false);
                dialog.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
            }
        });
    }
}