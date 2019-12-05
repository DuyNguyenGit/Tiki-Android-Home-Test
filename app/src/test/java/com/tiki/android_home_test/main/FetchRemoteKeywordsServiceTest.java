package com.tiki.android_home_test.main;

import com.tiki.android_home_test.keywords_feature.FetchRemoteKeywordsService;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FetchRemoteKeywordsServiceTest {

    @Test
    public void makeOnlyOneSpaceBetweenTwoWords() {
        String input = "   Nguyễn    Nhật  Ánh";
        String expectOutput = "Nguyễn Nhật Ánh";
        FetchRemoteKeywordsService service = new FetchRemoteKeywordsService();
        String output = service.makeOnlyOneSpaceBetweenTwoWords(input);
        assertThat(output, is(expectOutput));
    }
}