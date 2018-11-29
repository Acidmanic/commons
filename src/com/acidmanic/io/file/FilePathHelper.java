/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file;

import com.acidmanic.io.file.exceptions.InvalidFilePathException;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class FilePathHelper {
    
    public FilePathHelper() {
    }

    public String getPathSeparator() {
        return FileSystems.getDefault().getSeparator();
    }

    protected String checkFileSystemRootDirectory(String path) {
        //ISSUE: LINUX-ONLY code
        if ("".equals(path)) {
            return "/";
        }
        return path;
    }

    public File getParentFile(String filePath) {
        return getParentFile(Paths.get(filePath));
    }

    public File getParentFile(File file) {
        return getParentFile(file.toPath());
    }
    public File getParentFile(Path file) {
        Path res = file.normalize().toFile()
                .getAbsoluteFile().toPath()
                .getParent();
        if (res != null){
            return res.toFile();
        }
        return null;
    }

    public String[] splitPath(String filePath) {
        String sep = getPathSeparator();
        int st = 0;
        ArrayList<String> parts = new ArrayList<>();
        while (st < filePath.length() && st > -1) {
            int nd = filePath.indexOf(sep, st + 1);
            if (nd == -1) {
                nd = filePath.length();
            }
            if (nd - st > 0) {
                parts.add(filePath.substring(st, nd));
            }
            st = nd;
        }
        String[] ret = new String[parts.size()];
        return parts.toArray(ret);
    }

    public boolean isGlob(String part) {
        String[] globPatterns = {".*\\*+.*", ".*\\?+.*", ".*\\[:upper:\\]+.*", ".*\\[:lower:\\]+.*"};
        for (String regex : globPatterns) {
            if (part.matches(regex)) {
                return true;
            }
        }
        return false;
    }

    public String pruneDots(String path) throws InvalidFilePathException {
        String[] parts = splitPath(path);
        ArrayList<String> res = new ArrayList<>();
        String sngl = this.getPathSeparator() + ".";
        String dbl = sngl + ".";
        for (String part : parts) {
            if (dbl.equals(part)) {
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                } else {
                    throw new InvalidFilePathException();
                }
            }
            if (!sngl.equals(part)) {
                res.add(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        res.forEach((String p) -> sb.append(p));
        return sb.toString();
    }

    public String endWithSeparator(String path) {
        if (path.endsWith(getPathSeparator())) {
            return path;
        }
        return path + getPathSeparator();
    }
    
    public Path currentDirectory(){
        return new File(".").getAbsoluteFile().toPath().normalize();
    }

    public File getRootOf(Path path) {
        if(!path.isAbsolute()){
            path = currentDirectory();
        }
        Iterable<Path> roots =
                FileSystems.getDefault().getRootDirectories();
        
        for(Path root:roots){
            if(path.startsWith(root)){
                return root.toFile();
            }
        }
        return null;
    }
}
