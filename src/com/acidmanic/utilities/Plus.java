/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 * @param <Tmain>
 * @param <Textera>
 */
public class Plus<Tmain, Textera> {

    private Tmain main;
    private Textera extera;

    public Plus() {
        this.main=null;
        this.extera=null;
    }

    public Plus(Tmain main, Textera add) {
        this.main = main;
        this.extera = add;
    }

    public Tmain get() {
        return main;
    }

    public void set(Tmain main) {
        this.main = main;
    }

    public Textera getExtera() {
        return extera;
    }

    public void setExtera(Textera extera) {
        this.extera = extera;
    }

    
    
}
