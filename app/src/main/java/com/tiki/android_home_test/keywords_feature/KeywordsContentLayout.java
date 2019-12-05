package com.tiki.android_home_test.Main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.tiki.android_home_test.R;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class KeywordsContentLayout extends LinearLayout {
    private View rootView;
    private RecyclerView rcv;
    private KeywordAdapter adapter;

    public KeywordsContentLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public KeywordsContentLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public KeywordsContentLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        rootView = LayoutInflater.from(context).inflate(R.layout.layout_content_keywords, this);
        rcv = rootView.findViewById(R.id.rcvKeywords);
        adapter = new KeywordAdapter();
        rcv.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        rcv.setAdapter(adapter);
    }

    public void show() {
        this.setVisibility(VISIBLE);
    }

    public void hide() {
        this.setVisibility(GONE);
    }

    public void updateList(List<String> newestKeywords) {
        this.adapter.updateList(newestKeywords);
    }
}
