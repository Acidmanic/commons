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
public class CaseInsensitiveComparison implements StringComparison{

    @Override
    public boolean areEqual(String value1, String value2) {
        return value1.toLowerCase().compareTo(value2.toLowerCase()) == 0;
    }
    
}
