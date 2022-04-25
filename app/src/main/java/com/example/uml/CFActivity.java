
package com.example.uml;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputFilter;
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
    }
}