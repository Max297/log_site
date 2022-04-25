package com.example.demo;

import com.example.demo.domain.UserEntity;
import com.example.demo.repos.User_sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Login_controller
{

    @Autowired private User_sevice service;

    @GetMapping("/login")
    public String welcome(Model model)
    {
        model.addAttribute("new_user",new UserEntity());
        return "login";
    }
    @PostMapping("/login/try")
    public String enter(Model model,UserEntity user)
    {
        List<UserEntity> users=service.listall();
        for (int i=0;i<users.size();i++)
        {
            if (users.get(i).getName().equals(user.getName())&&users.get(i).getPass().equals(user.getPass()) )
            {
                if (users.get(i).getName().equals("admin"))
                {
                    model.addAttribute("listUsers",users);
                    return "admin_page";
                }
                UserEntity this_user=users.get(i);
                model.addAttribute("logged_user",this_user);
                return "welcome";
            }
        }
        return "login";
    }
}
