/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities.statemachines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <TState> Type Of Class Determining the state of the machine
 * @param <TInput> Type Of the input
 */
public class StateMachine<TState, TInput> {

    private final HashMap<TState, List<Transition<TState, TInput>>> transitions;
    private TState currentState;

    public StateMachine(TState startState) {
        this.transitions = new HashMap<>();
        this.currentState = startState;
    }

    public void addTransition(TState state,
            Transition<TState, TInput> transition) {
        if (!this.transitions.containsKey(state)) {
            this.transitions.put(state, new ArrayList<>());
        }
        this.transitions.get(state).add(transition);
    }

    public void pass(TInput input) {
        TState key = this.currentState;
        if (this.transitions.containsKey(key)) {
            this.transitions.get(key)
                    .forEach(t -> this.currentState = t.pass(this.currentState,input));
        }
    }

    public TState getCurrentState() {
        return currentState;
    }

    
}
