package com.codecool.KonradL;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FileWordAnalyzer {

    private FilePartReader reader;

    public FileWordAnalyzer(FilePartReader reader) {
        this.reader = reader;
    }

    public ArrayList wordsByABC(){

        ArrayList<String> words = loadWords();

        Collections.sort(words, String.CASE_INSENSITIVE_ORDER);

        return words;
    }

    public ArrayList wordsContainingSubString(String subString){

        ArrayList<String> tempWords = new ArrayList<>();
        ArrayList<String> words = loadWords();

        for(String word : words){
            if(word.contains(subString)) tempWords.add(word);
        }

        return tempWords;
    }

    public ArrayList wordsArePalindrome(){

        ArrayList<String> tempWords = new ArrayList<>();
        ArrayList<String> words = loadWords();

        for(String word : words){

            if(word.equals(new StringBuilder(word).reverse().toString())) {
                tempWords.add(word);
            }
        }
        return tempWords;
    }

    private ArrayList<String> loadWords(){

        ArrayList<String> words = new ArrayList<>();

        try {

            Scanner lines = new Scanner(this.reader.readLines());

            while(lines.hasNext()){

                String word = lines.next();
                if (word.length() > 0) words.add(word);
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return words;
    }
}
