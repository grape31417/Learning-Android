package com.example.bluedream.myfirstapp;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by USER on 2017/10/24.
 */

public class MarriageSuggestionTest {
    @Test
    public void getSuggestion()
    {
        MarriageSuggestion marriageSuggestion = new MarriageSuggestion();
        String s= marriageSuggestion.getSuggestion("男",25);
        assertEquals(s,"還不急");
        s= marriageSuggestion.getSuggestion("男",30);
        assertEquals(s,"開始找對象");
        s= marriageSuggestion.getSuggestion("男",34);
        assertEquals(s,"趕快結婚");
        s= marriageSuggestion.getSuggestion("女",24);
        assertEquals(s,"還不急");
        s= marriageSuggestion.getSuggestion("女",29);
        assertEquals(s,"開始找對象");
        s= marriageSuggestion.getSuggestion("女",31);
        assertEquals(s,"開始找對象");


    }
}
