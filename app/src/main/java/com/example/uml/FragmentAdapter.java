package com.example.uml;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.uml.Fragments.Fragments_All;
import com.example.uml.Fragments.Fragments_Complaints;
import com.example.uml.Fragments.Fragments_Confess;
import com.example.uml.Fragments.Fragments_Zhihu;

public class FragmentAdapter extends FragmentStateAdapter {

    private String[] mTitles = new String[]{"全部", "表白", "吐槽", "知乎"};

    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 0){
            return new Fragments_All();
        }
        else if(position == 1){
            return new Fragments_Confess();
        }
        else if(position == 2){
            return new Fragments_Complaints();
        }
        else if(position == 3){
            return new Fragments_Zhihu();
        }
        return new Fragments_All();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
