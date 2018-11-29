/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

import java.util.concurrent.Callable;

/**
 * Unsafe Lazy can return null instead of throwing an exception
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <T>
 */
public class UnsafeLazy<T> extends Lazy<T> {
    
    public UnsafeLazy(Callable<T> builder) {
        super(builder);
    }

    @Override
    public synchronized T get() {
        try {
            return super.get();
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
}
