package com.example.demo;

import com.example.demo.domain.UserEntity;
import com.example.demo.repos.User_sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Admin_controller
{
    @Autowired
    User_sevice service;
    @GetMapping("/admin_page")
    public String welcome(Model model)
    {
        model.addAttribute("listUsers",service.listall());
        return "admin_page";
    }
    @GetMapping("admin/add")
    public String add_page(Model model)
    {
        UserEntity user=new UserEntity();
        model.addAttribute("user",user);
        return "admin_add";
    }
    @PostMapping("/admin/add")
    public String add(UserEntity user,Model model)
    {
        user.setUserdId(service.get_ID());
        service.add(user);
        model.addAttribute("listUsers",service.listall());
        return "admin_page";
    }
    @GetMapping ("/admin/edit/{id}")
    public String edit_page(@PathVariable ("id")Integer id,Model model)
    {
        UserEntity user=service.get_by_ID(id);
        user.setUserdId(id);
        model.addAttribute("user",user);
        return "admin_edit";
    }
    @PostMapping("/admin/edit/")
    public String edit(Model model,UserEntity user)
    {
        service.delete(service.get_by_ID(user.getUserdId()));
        service.add(user);
        model.addAttribute("listUsers",service.listall());
        return "admin_page";
    }

    @GetMapping ("/admin/delete/{id}")
    public String delete(@PathVariable ("id")Integer id,Model model)
    {
        service.delete(service.get_by_ID(id));
        model.addAttribute("listUsers",service.listall());
        return "admin_page";
    }
}
