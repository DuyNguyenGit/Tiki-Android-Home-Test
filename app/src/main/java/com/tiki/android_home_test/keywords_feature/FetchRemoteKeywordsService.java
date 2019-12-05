package com.tiki.android_home_test.keywords_feature;

import android.os.AsyncTask;
import android.util.Log;

import com.tiki.android_home_test.network.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class FetchRemoteKeywordsService extends AsyncTask<String, Void, List<String>> {

    private static final String TAG = FetchRemoteKeywordsService.class.getSimpleName();
    private GetKeywordsListener listener;

    public FetchRemoteKeywordsService(GetKeywordsListener listener) {
        this.listener = listener;
    }

    public FetchRemoteKeywordsService() {

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        listener.startFetchData();
    }

    @Override
    protected List<String> doInBackground(String... strings) {
        final List<String> keywordList = new ArrayList<>();
        final String url = strings[0];
        final HttpHandler httpHandler = new HttpHandler(this.listener);
        final String response = httpHandler.makeServiceCall(url);
        if (response != null) {
            try {
                JSONArray keywordArray = new JSONArray(response);
                for (int i = 0; i < keywordArray.length(); i++) {
                    keywordList.add(breakString((String) keywordArray.get(i)));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return keywordList;
    }

    private String breakString(String input) {
        String output = makeOnlyOneSpaceBetweenTwoWords(input);

        if (output.contains(" ")) {
            Log.i(TAG, "breakString: " + output);
            int length = output.length();
            int centerpoint = length / 2 - 1;
            if (output.charAt(centerpoint) == ' ') {
                output = enterStringAt(output, centerpoint);
            } else {
                int breakPoint = length;
                int leftCenterPoint;
                for (int i = centerpoint + 1; i < output.length(); i++) {
                    if (output.charAt(i) == ' ') {
                        breakPoint = i;
                        break;
                    }
                    leftCenterPoint = length - i - 2;
                    if (output.charAt(leftCenterPoint) == ' ') {
                        breakPoint = leftCenterPoint;
                        break;
                    }
                }
                output = enterStringAt(output, breakPoint);
            }
        }
        Log.e(TAG, "breakString: " + output);
        return output;
    }

    public String makeOnlyOneSpaceBetweenTwoWords(String input) {
        String output = input.trim().replaceAll(" +", " ");
        return output;
    }

    public String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    public String enterStringAt(String str, int p) {
        return str.substring(0, p) + "\n" + str.substring(p + 1);
    }

    @Override
    protected void onPostExecute(List<String> keywordList) {
        super.onPostExecute(keywordList);
        this.listener.onSuccess(keywordList);
        this.listener.stopFetchData();
    }

    public interface GetKeywordsListener {
        void startFetchData();

        void stopFetchData();

        void onSuccess(List<String> newKeywords);

        void onError(String errorMsg);
    }
}
