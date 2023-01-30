package com.sdl.project_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProjectController {

    @GetMapping("/home")
    public String homepage(){
        return "index";
    }
}
