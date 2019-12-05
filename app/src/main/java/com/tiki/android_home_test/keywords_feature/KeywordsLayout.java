package com.tiki.android_home_test.keywords_feature;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.tiki.android_home_test.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class KeywordsLayout extends RelativeLayout implements KeywordsView {

    private KeywordsErrorLayout keywordsErrorLayout;
    private KeywordsContentLayout keywordsContentLayout;
    private KeywordsViewListener viewListener;
    private Context context;

    public KeywordsLayout(@NonNull Context context) {
        super(context);
        init(context, null, 0);
    }

    public KeywordsLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public KeywordsLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        final View view = LayoutInflater.from(context).inflate(R.layout.layout_keywords, this);
        keywordsErrorLayout = view.findViewById(R.id.layoutKeywordsError);
        keywordsContentLayout = view.findViewById(R.id.layoutKeywordsContent);
    }

    public void setViewListener(KeywordsViewListener viewListener) {
        this.viewListener = viewListener;
    }

    public void fetchKeywordList() {
        KeywordsPresenter presenter = new KeywordsPresenter(this);
        presenter.fetchKeywordList();
    }

    @Override
    public void startLoading() {
        this.viewListener.showLoading();
    }

    @Override
    public void stopLoading() {
        this.viewListener.hideLoading();
    }

    @Override
    public void updateKeywordList(List<String> fetchedData) {
        showKeywordsView();
        keywordsContentLayout.updateList(fetchedData);
    }

    private void showKeywordsView() {
        keywordsContentLayout.show();
        keywordsErrorLayout.hide();
    }

    @Override
    public void showError(final String errorMsg) {
        this.post(new Runnable() {
            @Override
            public void run() {
                keywordsContentLayout.hide();
                keywordsErrorLayout.show(errorMsg);
            }
        });
    }
}
