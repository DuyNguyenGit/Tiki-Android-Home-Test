package com.tiki.android_home_test.keywords_feature;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tiki.android_home_test.R;

public class KeywordsErrorLayout extends RelativeLayout {

    private View rootView;
    private TextView tvErrorMsg;
    private RelativeLayout layoutError;

    public KeywordsErrorLayout(Context context) {
        super(context);
        init(context, null, 0);
    }

    public KeywordsErrorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public KeywordsErrorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        rootView = LayoutInflater.from(context).inflate(R.layout.layout_error_keywords, this);
        tvErrorMsg = rootView.findViewById(R.id.tvErrorKeywords);
        layoutError = rootView.findViewById(R.id.errorKeywordsView);
    }

    public void hide() {
        layoutError.setVisibility(GONE);
    }

    public void show(String errorMsg) {
        layoutError.setVisibility(VISIBLE);
        tvErrorMsg.setText(errorMsg);
    }
}
