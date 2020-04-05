package com.example.viewpager_lab4;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.viewpager_lab4.Fragment.List;
import com.example.viewpager_lab4.Fragment.Page;

public class class2 extends AppCompatActivity implements List.OnFragmentInteractionListener {

    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2);
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.fragList,new List(),"fragList")
                .commit();
    }

    @Override
    public void onFragmentInteraction(String result) {

        String url = result;
        switch (result){
            case "Google":
                url = "https://www.google.com/";
                break;
            case "pinterest":
                url = "https://www.pinterest.com/";
                break;
            case "yakaboo":
                url = "https://www.yakaboo.ua/ru/";
                break;
            case "Helvetica":
                url = "https://vimeo.com/15659366";
                break;
        }
        manager.beginTransaction()
                .add(R.id.fragPage, Page.newInstance(url),"fragPage")
                .commit();
    }
}
