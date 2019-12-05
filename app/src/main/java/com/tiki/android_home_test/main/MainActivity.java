package com.tiki.android_home_test.main;

import android.os.Bundle;
import android.view.View;

import com.tiki.android_home_test.R;
import com.tiki.android_home_test.keywords_feature.KeywordsLayout;
import com.tiki.android_home_test.keywords_feature.KeywordsView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements KeywordsView.KeywordsViewListener {

    private View loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingView = findViewById(R.id.layoutLoading);
        KeywordsLayout layoutKeywords = findViewById(R.id.layoutKeywords);
        layoutKeywords.setViewListener(this);
        layoutKeywords.fetchKeywordList();
    }

    @Override
    public void showLoading() {
        loadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingView.setVisibility(View.GONE);
    }
}
