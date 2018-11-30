/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse.stringcomparison;

import static com.acidmanic.parse.stringcomparison.StringComparison.COMPARE_CASE_INSENSITIVE;
import static com.acidmanic.parse.stringcomparison.StringComparison.COMPARE_CASE_SENSITIVE;
import java.util.HashMap;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class StringComparisionFactory {

    private static final HashMap<Integer, StringComparison> comparisons = initializeComparisons();

    private static HashMap<Integer, StringComparison> initializeComparisons() {
        HashMap<Integer, StringComparison> ret = new HashMap<>();
        ret.put(COMPARE_CASE_SENSITIVE, new CaseSensitiveCompare());
        ret.put(COMPARE_CASE_INSENSITIVE, new CaseInsensitiveComparison());
        return ret;
    }

    public StringComparison make() {
        return comparisons.get(COMPARE_CASE_SENSITIVE);
    }

    public StringComparison make(int comparision) {
        if (comparisons.containsKey(comparision)) {
            return comparisons.get(comparision);
        }
        return make();
    }
}
