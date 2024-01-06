package com.haeny.lec11.java;

public abstract class StringUtils {

    private StringUtils() {}

    public boolean isDirectoryPath(String path) {
        return path.endsWith("/");
    }
}
