/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities.statemachines;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <TState>
 * @param <TInput>
 */
public interface Transition<TState,TInput> {
    TState pass(TState from,TInput withData);
}
