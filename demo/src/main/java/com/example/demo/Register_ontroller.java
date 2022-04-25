package com.example.demo;

import com.example.demo.domain.UserEntity;
import com.example.demo.repos.DbRepo;
import com.example.demo.repos.User_sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Register_ontroller
{

    @Autowired private User_sevice service;

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("new_user",new UserEntity());
        return "register";
    }
    @PostMapping("/register/add")
    public String check(UserEntity user)
    {
        List<UserEntity> users=service.listall();
        for (int i=0;i<users.size();i++)
        {
            if (users.get(i).getName().equals(user.getName())||users.get(i).getMail().equals(user.getMail())||users.get(i).getPass().equals(user.getPass()) )
            {
                return "register";
            }
        }
        user.setUserdId(users.size()+1);
        service.add(user);
        return "login";
    }
}
