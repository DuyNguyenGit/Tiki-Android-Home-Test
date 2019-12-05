package com.tiki.android_home_test.keywords_feature;

import java.util.List;

public interface KeywordsView {

    void startLoading();

    void stopLoading();

    void updateKeywordList(List<String> fetchedData);

    void showError(String errorMsg);

    interface KeywordsViewListener {
        void showLoading();

        void hideLoading();
    }
}
