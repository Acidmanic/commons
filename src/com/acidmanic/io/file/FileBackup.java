/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class FileBackup {
    
    private byte[] data;
    private String path;

    public FileBackup(String path) {
        this.path = path;
        try {
            this.data = Files.readAllBytes(Paths.get(path));
        } catch (Exception e) {
        }
        this.path = path;
    }

    public byte[] getData() {
        return data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void restore() {
        try {
            File f = new File(this.path);
            if (f.exists()) {
                f.delete();
            }
            Files.write(f.toPath(), this.data, StandardOpenOption.CREATE);
        } catch (Exception e) {
        }
    }
    
}
