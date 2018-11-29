/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

import java.util.concurrent.Callable;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com) This class makes it
 * possible to create any object once, and when it has been used for the first
 * time, having their builder object or builder lambda expression.
 *
 * @param <T> the type of the object being created lazily.
 */
public class Lazy<T> {

    private final Callable<T> builder;
    private T object = null;

    public Lazy(Callable<T> builder) {
        this.builder = builder;
    }

    public synchronized T get() throws Exception {
        if (this.object == null) {
            if (builder == null) {
                throw new NullPointerException();
            }
            this.object = builder.call();
        }
        return this.object;
    }

    public void markAsNotLoaded() {
        this.object = null;
    }
}
