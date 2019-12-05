package com.tiki.android_home_test.Main;

import android.util.Log;

import java.util.List;

public class KeywordsPresenter implements FetchRemoteKeywordsService.GetKeywordsListener {

    private static final String TAG = KeywordsPresenter.class.getSimpleName();
    private KeywordsView keywordsView;

    public KeywordsPresenter(KeywordsView keywordsView) {
        this.keywordsView = keywordsView;
    }

    public void fetchKeywordList() {
        final FetchRemoteKeywordsService service = new FetchRemoteKeywordsService(this);
        service.execute(Constants.keywordsUrl);
    }

    @Override
    public void startFetchData() {
        keywordsView.startLoading();
    }

    @Override
    public void stopFetchData() {
        keywordsView.stopLoading();
    }

    @Override
    public void onSuccess(List<String> newKeywords) {
        Log.i(TAG, "onSuccess: "+ newKeywords.size());
        keywordsView.updateKeywordList(newKeywords);
    }

    @Override
    public void onError(String errorMsg) {
        keywordsView.showError(errorMsg);
    }
}
