/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acidmanic.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mani Moayedi (acidmanic.moayedi@gmail.com)
 */
public class FileSystemHelper {

    private abstract class MileVisitor implements FileVisitor<Path> {

        protected Path currentDirectory;

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            this.currentDirectory = dir;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

    }

    public FileSystemHelper() {
    }

    public void clearDirectory(String path) {
        File file = new File(path);
        if (file.isDirectory() == false) {
            file.delete();
            return;
        }
        File[] content = file.listFiles();
        for (File innerFile : content) {
            deleteDirectory(innerFile.getAbsolutePath());
        }
    }

    public void deleteDirectory(String path) {
        File file = new File(path);
        if (file.isDirectory() == false) {
            file.delete();
            return;
        }
        File[] content = file.listFiles();
        for (File innerFile : content) {
            deleteDirectory(innerFile.getAbsolutePath());
        }
        file.delete();
    }

    public void copyDirectory(String src, String dst, CopyOption copyOption) throws IOException {
        Path srcBase = Paths.get(src);
        Path dstBase = Paths.get(dst);
        copyDirectory(srcBase, dstBase, copyOption);
    }

    public void copyDirectory(String src, String dst) throws IOException {
        copyDirectory(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }

    public void copyDirectory(Path src, Path dst, CopyOption copyOption) throws IOException {
        Files.walkFileTree(src, new MileVisitor() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path dstDirectory = dst.resolve(src.relativize(this.currentDirectory));
                dstDirectory.toFile().mkdirs();
                Path dstPath = dst.resolve(src.relativize(file));
                Files.copy(file, dstPath, copyOption);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public void copy(String src, String dst) throws Exception {
        copy(Paths.get(src), Paths.get(dst));
    }

    public void copy(Path src, Path dst, CopyOption copyOption) throws Exception {
        if (src.toFile().isDirectory()) {
            copyDirectory(src.toString(), dst.toString(), copyOption);
        } else {
            Path parent = dst.getParent().normalize();
            parent.toFile().mkdirs();
            Files.copy(src, dst, copyOption);
        }
    }

    public void copy(Path src, Path dst) throws Exception {
        copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }

    protected List<Path> pathsOf(List<String> files) {
        List<Path> ret = new ArrayList<>();
        files.forEach((String file) -> ret.add(Paths.get(file)));
        return ret;
    }

    public void copyList(String srcBaseDirectory, List<String> selectedFiles,
            String destinationDirectory, CopyOption copyOption) throws Exception {
        List<Path> srcPaths = pathsOf(selectedFiles);
        Path dstPath = Paths.get(destinationDirectory);
        Path srcBase = Paths.get(srcBaseDirectory);
        List<Exception> exceptions = new ArrayList<>();
        srcPaths.forEach(src -> {
            try {
                copy(src, dstPath.resolve(srcBase.relativize(src)), copyOption);
            } catch (Exception e) {
                exceptions.add(e);
            }
        });
        for (Exception e : exceptions) {
            throw e;
        }
    }

    public void copyList(String srcBaseDirectory, List<String> selectedFiles,
            String destinationDirectory) throws Exception {
        copyList(srcBaseDirectory, selectedFiles, destinationDirectory,
                StandardCopyOption.REPLACE_EXISTING);
    }

}
