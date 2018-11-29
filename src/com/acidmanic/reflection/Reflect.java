/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.reflection;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class Reflect {
    
    public static boolean doesImplement(Class type,Class interfaceType){
        Class[] interfaces = type.getInterfaces();
        for(Class intf:interfaces){
            if(intf.getName().compareTo(interfaceType.getName())==0){
                return true;
            }
        }
        return false;
    }
}
