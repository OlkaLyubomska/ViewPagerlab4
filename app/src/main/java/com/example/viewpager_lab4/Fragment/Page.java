package com.example.viewpager_lab4.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpager_lab4.R;

public class Page extends Fragment {

    private static final String ARG_PARAM1 = "https://www.google.com/";

    private String mParam1;

    public Page() {}

    public static Page newInstance(String param1) {
        Page fragment = new Page();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_fragment, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        WebView web = view.findViewById(R.id.web);

        WebSettings webSettings = web.getSettings();
        webSettings.setAppCacheEnabled(true);
        webSettings.setCacheMode(webSettings.LOAD_CACHE_ELSE_NETWORK);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setAllowFileAccess(true);

        //if SDK version is greater of 19 then activate hardware acceleration otherwise activate software acceleration
        web.setLayerType(View.LAYER_TYPE_HARDWARE, null);

        web.loadUrl(mParam1);

        //web.setWebViewClient(new WebViewClient());


    }
}


