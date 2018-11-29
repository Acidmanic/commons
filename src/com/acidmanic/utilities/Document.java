/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.utilities;

import java.io.File;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 *
 * This class can provide and manage saving and loading a savable data to a
 * file. it relates the Data to a specific file.
 * @param <T> Where T is a SavableData is the data which is supposed to be
 * linked to a specific file.
 */
public class Document<T extends SavableData> {

    private T data;
    private final Class<T> savableType;
    private File file;
    private boolean fileOnDisk = false;

    public Document(T data, File file) {
        this.data = data;
        this.file = file;
        this.savableType = (Class<T>) data.getClass();
        this.fileOnDisk = false;
    }

    public Document(T data, String file) {
        this.data = data;
        this.file = new File(file);
        this.savableType = (Class<T>) data.getClass();
        this.fileOnDisk = this.file.exists();
    }

    public Document(Class<T> savableType, File file) {
        this.file = file;
        this.savableType = savableType;
        
        try {
            this.data = this.savableType.newInstance();
            if (file.exists()) {
                this.data.load(file.getAbsolutePath());
                this.fileOnDisk = true;
            }
            return;
        } catch (Exception e) {
        }
        this.data = null;
    }

    public void save() {
        if (this.file.exists()) {
            try {
                this.file.delete();
            } catch (Exception e) {
            }
        }
        data.save(this.file.getAbsolutePath());
        this.fileOnDisk = true;
    }

    public void saveAs(String filepath) {
        this.file = new File(filepath);
        save();
    }

    public T getData() {
        return this.data;
    }

    public File getFile() {
        return this.file;
    }

    public boolean tryDelete() {
        try {
            if (this.file.exists()) {
                this.file.delete();
            }
            this.fileOnDisk = false;
            return true;

        } catch (Exception e) {
        }
        return false;
    }

    public boolean isFileOnDisk() {
        return fileOnDisk;
    }
    
    

}
