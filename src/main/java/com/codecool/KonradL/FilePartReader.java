package com.codecool.KonradL;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;

    public FilePartReader() {
        filePath = "none";
        fromLine = 1;
        toLine = 3;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {

        if (toLine < fromLine) throw new IllegalArgumentException();
        if (fromLine < 1) throw new IllegalArgumentException();

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    private String read() throws FileNotFoundException {

        String content = new Scanner(new File(this.filePath)).useDelimiter("\\Z").next();

        return content;
    }

    public String readLines() throws FileNotFoundException, IndexOutOfBoundsException {

        String temp = "";

        String[] lines = read().split("\\n");

        if (toLine  <= lines.length){

            for(int i=fromLine - 1; i < toLine ; i++) temp += lines[i] + "\n";
        }
        else throw new IndexOutOfBoundsException();

        return temp;
    }
}