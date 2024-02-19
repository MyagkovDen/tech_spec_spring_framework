package com.denmiagkov.mywebapp.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    public String greet(){
        return "greeting";
    }

    @GetMapping("/now")
    public String getCurrentDateAndTime(Model model){
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
         model.addAttribute("date", date);
         model.addAttribute("time", time);
        return "time";
    }
}
