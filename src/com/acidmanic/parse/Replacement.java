/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse;

import com.acidmanic.parse.indexbased.IndexBasedParser;
import com.acidmanic.parse.indexbased.SubString;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Replacement {

    
    /**
     * 
     * Replaces any occurrence of given tag with replacement string. unless the tag 
     * has been escaped by \ char.
     * 
     * @param content 
     * @param tag
     * @param replacement
     * @return 
     */
    public String replace(String content, String tag, String replacement) {
        return replace(content, tag, replacement, '\\');
    }
/**
     * 
     * Replaces any occurrence of given tag with replacement string. unless the tag 
     * has been escaped by given escape char.
     * 
     * @param content 
     * @param tag
     * @param replacement
     * @param escape
     * @return 
     */
    public String replace(String content, String tag, String replacement, char escape) {

        int st = content.indexOf(tag);

        while (st != -1) {

            int substringLength = tag.length();

            String toBeReplaced = replacement;

            if (escaped(content, st, escape)) {
                st -= 1;
                substringLength += 1;
                toBeReplaced = tag;
            }

            SubString sub = new SubString(st, st + substringLength);

            content = new IndexBasedParser().
                    replace(content, sub, toBeReplaced);

            st = content.indexOf(tag,
                    st + toBeReplaced.length());
        }

        return content;

    }

    private boolean escaped(String content, int st, char escape) {
        if (st == 0) {
            return false;
        }
        return content.charAt(st - 1) == escape;
    }
}
