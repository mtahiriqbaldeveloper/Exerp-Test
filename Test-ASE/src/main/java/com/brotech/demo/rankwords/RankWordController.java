package com.brotech.demo.rankwords;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.FileNotFoundException;
import java.util.Dictionary;

@Controller
@RestController
@RequestMapping(path = "api")
public class RankWordController {

    public final RankWordService rankWordService;

    public RankWordController(RankWordService rankWordService) {
        this.rankWordService = rankWordService;
    }

    @GetMapping(path = "/top-words")
    public Dictionary<String, Integer> displayTopWords() throws FileNotFoundException {

        return rankWordService.getTopRankWords();
    }

}
