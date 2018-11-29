/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * This is a generic wrapper that is supposed to make a non-final
 * value, looks final! the reason is to make ease of using the non-final 
 * types in forEach lambda loops.
 * @param <T>
 */
public class Final<T> {

    private T value;

    public Final(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

}
