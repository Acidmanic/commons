/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * 
 * 
 * Any data class implementing this interface can be known to have ability to be 
 * saved to and loaded from a file.
 */
public interface SavableData {
    void save(String filepath);
    void load(String filepath);
}
