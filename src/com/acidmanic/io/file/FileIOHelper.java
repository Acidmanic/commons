/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class FileIOHelper {

    public void tryWriteAll(String filePath, String content) {
        tryWriteAll(new File(filePath), content);
    }

    public void tryWriteAll(File file, String content) {
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e) {
            }
        }
        try {
            Files.write(file.toPath(),
                    content.getBytes(),
                    StandardOpenOption.CREATE);
        } catch (Exception e) {
        }

    }

    public List<String> tryReadAllLines(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (Exception e) {
        }
        return new ArrayList<>();
    }

    public List<String> tryReadAllLines(String path) {
        return tryReadAllLines(new File(path));
    }

    public String tryReadAllText(File file) {
        try {
            return new String(
                    Files.readAllBytes(file.toPath())
            );
        } catch (Exception e) {
        }
        return null;
    }

    public String tryReadAllText(String path) {
        try {
            return new String(
                    Files.readAllBytes(Paths.get(path))
            );
        } catch (Exception e) {
        }
        return null;
    }

    public void tryAppendText(String text, String filepath) {
        try {
            text += "\n";
            Files.write(Paths.get(filepath),
                    text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ex) {
        }
    }
}
