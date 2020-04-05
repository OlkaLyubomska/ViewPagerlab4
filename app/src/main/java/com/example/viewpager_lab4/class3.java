package com.example.viewpager_lab4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.viewpager_lab4.Fragment.ImageFragment;
import com.example.viewpager_lab4.Fragment.ImageFragment3;
import com.example.viewpager_lab4.Fragment.ImageFragment2;
import com.google.android.material.tabs.TabLayout;

public class class3 extends AppCompatActivity {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class3);

        manager = getSupportFragmentManager();
        ViewPager viewPager = findViewById(R.id.viewPager);
        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(viewPager);
        viewPager.setAdapter(new meAdapter(manager));
    }
}

class meAdapter extends FragmentPagerAdapter{

    public meAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "postmodern";
        else if(position == 1)
            return "modern";
        else
            return "renaissance";
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return ImageFragment.newInstance();}
        else
        if (position == 1) {
            return ImageFragment2.newInstance();
        }
        else
            return ImageFragment3.newInstance();
    }

    @Override
    public int getCount() {
        return 3;
    }
}

