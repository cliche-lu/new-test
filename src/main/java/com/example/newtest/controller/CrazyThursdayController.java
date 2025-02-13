package com.example.newtest.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@Slf4j
@RequestMapping("/crazy")
public class CrazyThursdayController {
    @GetMapping( value = "/thursday")
    public String crazyThursday() {
        return "crazyThursday";
    }
}
