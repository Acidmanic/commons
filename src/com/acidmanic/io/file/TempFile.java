/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file;

import com.acidmanic.io.file.FileSystemHelper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class TempFile {
    
    private final String name;
    private final Path location;
    private final File file;
    private final Boolean isDirectory;

    public TempFile(boolean isDirectory) {
        this.name = UUID.randomUUID().toString();
        this.location = Paths.get(System.getProperty("java.io.tmpdir"));
        this.file = this.location.resolve(Paths.get(this.name)).toFile();
        this.isDirectory = isDirectory;
        createMe(isDirectory);
    }

    private void createMe(boolean directory) {
        if (!this.file.exists()) {
            if (directory) {
                this.file.mkdirs();
            } else {
                try {
                    this.file.createNewFile();
                } catch (IOException ex) {
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public Path getLocation() {
        return location;
    }

    public File getFile() {
        return file;
    }

    public void dispose() {
        if (this.file.isDirectory()) {
            new FileSystemHelper().deleteDirectory(this.file.getAbsolutePath());
        } else {
            try {
                this.file.delete();
            } catch (Exception e) {
            }
        }
    }

    public Boolean getIsDirectory() {
        return isDirectory;
    }
    
}
