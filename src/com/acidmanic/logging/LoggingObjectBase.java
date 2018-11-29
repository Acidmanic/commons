/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.logging;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class LoggingObjectBase {
    private Logger logger;

    public LoggingObjectBase(Logger logger) {
        this.logger = logger;
    }

    public LoggingObjectBase() {
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    
    protected void log(String text){
        if(this.logger!=null){
            this.logger.log(text);
        }
    }
}
