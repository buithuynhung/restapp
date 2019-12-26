package com.programmerday.microservice.restapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/year")
    public @ResponseBody
    ProgrammerDay controller(@RequestParam String year) {
        return new ProgrammerDay(year);
    }
}

