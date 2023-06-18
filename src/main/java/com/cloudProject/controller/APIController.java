package com.cloudProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class APIController {


    @GetMapping("/")
    public String hello(){
        return "user/login";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "user/signUp";
    }


    @GetMapping("/post/new")
    public String newPost(){
        return "post/new";
    }




}
