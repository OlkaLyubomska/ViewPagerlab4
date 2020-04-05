package com.example.viewpager_lab4;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.example.viewpager_lab4.Fragment.DetailFragment;
import com.example.viewpager_lab4.Fragment.MenuFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.nextact, DetailFragment.nextact2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void nextact() {
        Intent intent = new Intent(this, class2.class);
        startActivity(intent);
    }

    @Override
    public void nextact2() {
        Intent intent = new Intent(this, class3.class);
        startActivity(intent);
    }
}

