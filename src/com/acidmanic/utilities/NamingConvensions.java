/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class NamingConvensions {
    
    public String getSnakecase(String camelOrPascal) {
        StringBuilder sb = new StringBuilder();
        char[] chars=camelOrPascal.toCharArray();
        char[] lows=camelOrPascal.toLowerCase().toCharArray();
        for(int i =0;i<chars.length;i++){
            if(Character.isUpperCase(chars[i])){
                sb.append("-");
            }
            sb.append(lows[i]);
        }
        String ret = sb.toString();
        if (ret.startsWith("-")){
            ret=ret.substring(1,ret.length());
        }
        return ret;
    }
}
