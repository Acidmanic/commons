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
 * This class wraps a value adding a boolean that indicates if the provided
 * value can be trusted or not.
 * @param <T> The type of wrapped value
 */
public class Result<T> {

    private boolean valid;
    private T value;

    public static final Result INVALIDATE = new Result<>(false, null);

    public Result(boolean valid, T value) {
        this.valid = valid;
        this.value = value;
    }

    public Result() {
        this.valid = false;
        this.value = null;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

}
