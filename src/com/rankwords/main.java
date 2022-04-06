package com.rankwords;

import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        RankWords rankWords = new RankWords();
       System.out.println(rankWords.getTopRankWords());
    }
}
