package com.codecool.KonradL;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    @Test
    public void testReadLinesBeforeSetup(){

        FilePartReader filePR = new FilePartReader();
        assertThrows(FileNotFoundException.class, ()-> filePR.readLines());
    }

    @Test
    public void testSetupFromLineLT1(){

        FilePartReader filePR = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> filePR.setup("test_data.txt", -1, 3));
    }

    @Test
    public void testSetupToLineLTFromLine(){

        FilePartReader filePR = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> filePR.setup("test_data.txt", 4, 1));
    }

    @Test
    public void testReadLines1_2() {

        try {
            FilePartReader filePR = new FilePartReader();
            filePR.setup("test_data.txt", 1, 2);
            assertEquals(generateLines(1,2), filePR.readLines());
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testReadLines2_4() {

        try {

            FilePartReader filePR = new FilePartReader();
            filePR.setup("test_data.txt", 2, 4);
            assertEquals(generateLines(2,4), filePR.readLines());

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

    }

    @Test
    public void testReadLinesAll()  {

        try {

            FilePartReader filePR = new FilePartReader();
            filePR.setup("test_data.txt", 1, 7);
            assertEquals(generateLines(1,7), filePR.readLines());

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    @Test
    public void testReadLinesPastEof() {

        FilePartReader filePR = new FilePartReader();
        filePR.setup("test_data.txt", 1, 8);
        assertThrows(IndexOutOfBoundsException.class, () -> filePR.readLines());
    }

    private String generateLines(Integer fromLine, Integer toLine){

        String temp = "";

        try{

            for(int i = fromLine-1; i < toLine; i++) temp += Files.readAllLines(Paths.get("test_data.txt")).get(i) + "\n";

        }
        catch (IOException e){
            e.printStackTrace();
            temp = "error";
        }

        return temp;

    }

}