package com.tiki.android_home_test.keywords_feature;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FetchRemoteKeywordsServiceTest {

    @Test
    public void breakString() {
        FetchRemoteKeywordsService service = new FetchRemoteKeywordsService();

        String input1 = "   Nguyễn    Nhật  Ánh";
        String expectOutput1 = "Nguyễn\nNhật Ánh";
        String output1 = service.breakString(input1);
        assertThat(output1, is(expectOutput1));


        String input2 = "   Le A A A  Nguyễn";
        String expectOutput2 = "Le A A\nA Nguyễn";
        String output2 = service.breakString(input2);
        assertThat(output2, is(expectOutput2));


    }

    @Test
    public void makeOnlyOneSpaceBetweenTwoWords() {
        String input = "   Nguyễn    Nhật  Ánh";
        String expectOutput = "Nguyễn Nhật Ánh";
        FetchRemoteKeywordsService service = new FetchRemoteKeywordsService();
        String output = service.makeOnlyOneSpaceBetweenTwoWords(input);
        assertThat(output, is(expectOutput));
    }
}