package com.brotech.demo.rankwords;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Service
@Slf4j
public class RankWordService {

    public Dictionary<String, Integer> getTopRankWords() throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("src/main/resources/static/data.txt")).useDelimiter("[^a-zA-Z]+");
        HashMap<String, Integer> map = new HashMap<>();

        while (fileScanner.hasNext()){
            String word = fileScanner.next().toLowerCase();
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> wordsEntry = new ArrayList<>(map.entrySet());
        Collections.sort(wordsEntry, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue().compareTo(b.getValue());
            }
        });

        log.info(wordsEntry.toString());
        Dictionary<String,Integer> topRankWords=new Hashtable<String,Integer>();
        for(int i = 0; i < 10; i++){

            topRankWords.put(wordsEntry.get(wordsEntry.size() - i - 1).getKey(),wordsEntry.get(wordsEntry.size() - i - 1).getValue());
//            System.out.println(wordsEntry.get(wordsEntry.size() - i - 1).getKey());
//            System.out.println(wordsEntry.get(wordsEntry.size() - i - 1).getValue());
        }

        return topRankWords;
    }

}
