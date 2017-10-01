package com.codecool.KonradL;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {

    @Test
    public void testWordsByABC(){

        FilePartReader filePR = new FilePartReader();
        filePR.setup("test_data.txt", 1,7);
        FileWordAnalyzer fileWA = new FileWordAnalyzer(filePR);

        ArrayList toCompare = new ArrayList(Arrays.asList("1a1", "2a", "2b", "3a", "3b", "3c", "4a", "4bb4", "4cr",
                "4d", "5ax", "5b", "5c", "5d", "5e", "6a", "6bb", "6ca", "6d", "6ea", "6f", "7ea", "7f", "7g"));

        assertEquals(toCompare, fileWA.wordsByABC());
    }

    @Test
    public void testWordsContainingSubString(){

        FilePartReader filePR = new FilePartReader();
        filePR.setup("test_data.txt", 1,7);
        FileWordAnalyzer fileWA = new FileWordAnalyzer(filePR);

        ArrayList toCompare = new ArrayList(Arrays.asList("1a1", "2a", "3a", "4a", "5ax", "6ea", "6ca", "6a", "7ea"));

        assertEquals(toCompare, fileWA.wordsContainingSubString("a"));
    }


    @Test
    public void testWordsArePalindrome(){

        FilePartReader filePR = new FilePartReader();
        filePR.setup("test_data.txt", 1,7);
        FileWordAnalyzer fileWA = new FileWordAnalyzer(filePR);

        ArrayList toCompare = new ArrayList(Arrays.asList("1a1", "4bb4"));

        assertEquals(toCompare, fileWA.wordsArePalindrome());
    }


}