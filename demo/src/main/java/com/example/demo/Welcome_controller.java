package com.example.demo;

import com.example.demo.repos.DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Welcome_controller
{
    @Autowired
    private DbRepo rep;
    @GetMapping("/welcome.html")
    public String welcome()
    {
        return "welcome";
    }
}
