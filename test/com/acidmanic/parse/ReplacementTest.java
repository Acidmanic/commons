/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse;

import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class ReplacementTest {
    
    public static final String REPLACING_TAG = "TESTY_TAG";
    public static final char ESCAPE = '\\';
    public static final String REPLACEMENT = "<New-Value>";
    
    public ReplacementTest() {
    }

    
    private String symetricContent(String containes) {
        return "some runish content before " + containes
                + " and some other after it!";
    }

    private String tagstartedContent(String containes) {
        return containes
                + " is now at the top of the contents.";
    }

    private class ContentPair {

        public String source;
        public String expected;
    }

    private ContentPair makeContents(String value, String tag, boolean... escapes) {
        String jibber = "lihdfn09w34h0 wrxf9uir2zr0 xeiufhw0ierfhs";
        ContentPair ret = new ContentPair();
        ret.source = "";
        ret.expected = "";
        Random r = new Random();
        String add;
        String sep = "";
        for (boolean escape : escapes) {
            add = sep + (r.nextBoolean() ? jibber : "");
            ret.expected += add + (escape ? tag : value);
            ret.source += add + (escape ? "\\" : "") + tag;
            sep = " ";
        }
        add = r.nextBoolean() ? jibber : "";
        ret.expected += add;
        ret.source += add;
        return ret;
    }

    @Test
    public void updateShouldReplaceTheTagWithVersion() {
        System.out.println("---- updateShouldReplaceTheTagWithVersion  ----");
        String content = symetricContent(REPLACING_TAG);
        String expected = symetricContent(REPLACEMENT);
        Replacement instance = new Replacement();
        String result = instance.replace(content, REPLACING_TAG, REPLACEMENT);
        assertEquals(expected, result);
    }

    @Test
    public void updateShouldReplaceStartingTag() {
        System.out.println("---- updateShouldReplaceStartingTag  ----");
        String content = tagstartedContent(REPLACING_TAG);
        String expected = tagstartedContent(REPLACEMENT);
        Replacement instance = new Replacement();
        String result = instance.replace(content, REPLACING_TAG, REPLACEMENT);
        assertEquals(expected, result);
    }
    
    @Test
    public void updateShouldReplaceEscapedsWithTagItsef() {
        System.out.println("---- updateShouldReplaceEscapedsWithTagItsef  ----");
        String content = symetricContent("\\"+REPLACING_TAG);
        String expected = symetricContent(REPLACING_TAG);
        Replacement instance = new Replacement();
        String result = instance.replace(content, REPLACING_TAG, REPLACEMENT);
        assertEquals(expected, result);
    }

    @Test
    public void updateShouldReplaceMultipileInstances() {
        System.out.println("---- updateShouldReplaceMultipileInstances  ----");
        ContentPair contents = makeContents(REPLACEMENT,REPLACING_TAG,
                false, false, false, false, false);
        Replacement instance = new Replacement();
        String result = instance.replace(contents.source, REPLACING_TAG, REPLACEMENT);
        System.out.println(result);
        assertEquals(contents.expected, result);
    }
    
    
    @Test
    public void updateShouldReplaceMultipileInstancesMixedWithEscapeds() {
        System.out.println("---- updateShouldReplaceMultipileInstancesMixedWithEscapeds  ----");
        ContentPair contents = makeContents(REPLACEMENT,REPLACING_TAG,
                false, true, false, true, false);
        Replacement instance = new Replacement();
        String result = instance.replace(contents.source, REPLACING_TAG, REPLACEMENT);
        System.out.println(result);
        assertEquals(contents.expected, result);
    }
    
}
