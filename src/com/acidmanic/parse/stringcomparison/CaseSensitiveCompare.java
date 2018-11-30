/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse.stringcomparison;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class CaseSensitiveCompare implements StringComparison{

    @Override
    public boolean areEqual(String value1, String value2) {
        return value1.compareTo(value2) == 0;
    }
}
