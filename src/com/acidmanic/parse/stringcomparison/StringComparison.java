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
public interface StringComparison {
    
    public static final int COMPARE_CASE_SENSITIVE = 0;
    public static final int COMPARE_CASE_INSENSITIVE = 1;
    
    
    boolean areEqual(String value1, String value2);
}
