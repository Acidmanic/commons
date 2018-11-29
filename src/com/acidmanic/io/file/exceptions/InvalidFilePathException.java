/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file.exceptions;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class InvalidFilePathException extends Exception {

    public InvalidFilePathException() {
        super("File path format is valid.");
    }
    
}
