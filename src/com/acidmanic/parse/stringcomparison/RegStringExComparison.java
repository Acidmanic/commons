/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.parse.stringcomparison;

/**
 *
 * @author Acidmanic
 */
public class RegStringExComparison implements StringComparison{

    @Override
    public boolean areEqual(String value1, String value2) {
        if(value1==null||value2==null) return false;
        return value1.matches(value2) || value2.matches(value1);
    }
    
}
