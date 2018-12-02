/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse.indexbased;

import com.acidmanic.utilities.Plus;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class IndexBasedParser {

    public String replace(String content, SubString subString, String replacement) {
        
        return setInside(content, subString, replacement).get();
    
    }

    public Plus<String, Integer> setInside(String content, SubString subString, String replacement) {
        
        String newContent = content.substring(0, subString.getBeginIndex());
        
        newContent += replacement;
        
        newContent += content.substring(subString.getEndIndex(), content.length());
        
        return new Plus<>(newContent, newContent.length() - content.length());
    }

    public String replaceAll(String content, List<SubString> subStrings, String replacement) {
        String ret = content;

        int move = 0;

        for (int i = 0; i < subStrings.size(); i++) {

            SubString sub = moveSubstring(subStrings.get(i), move);

            Plus<String, Integer> res = setInside(ret, sub, replacement);

            ret = res.get();

            move += res.getExtera();
        }
        return ret;
    }

    private SubString moveSubstring(SubString sub, int move) {

        return new SubString(sub.getBeginIndex() + move, sub.getEndIndex() + move);

    }
}
