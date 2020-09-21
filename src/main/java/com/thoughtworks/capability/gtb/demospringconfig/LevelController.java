package com.thoughtworks.capability.gtb.demospringconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class LevelController {

    @Value("${levelNumber}")
    private int levelNumber;

    @GetMapping("/level")
    public String getLevel() {
        return levelNumber < 1 ? "basic" : "advanced";
    }
}
