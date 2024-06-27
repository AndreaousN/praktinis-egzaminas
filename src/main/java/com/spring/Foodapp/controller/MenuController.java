package com.spring.Foodapp.controller;

import com.spring.Foodapp.model.Menu;
import com.spring.Foodapp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;
    @GetMapping("/menu")
    public String menu(Model model) {
        List<Menu> menuList = menuService.findAll();
        model.addAttribute("menuList", menuList);
        model.addAttribute("menu", new Menu());
        return "menu";
    }

    @PostMapping("/menu")
    public String menuSubmit(@ModelAttribute Menu menu, Model model) {
        menuService.save(menu);
        return "redirect:/menu";
    }
    @GetMapping("/menu/delete/{id}")
    public String deleteMenu(@PathVariable("id") int id, Model model){
        menuService.deleteById(id);
        return "redirect:/menu";
    }
    @GetMapping("/menu/edit/{id}")
    public String editMenu(@PathVariable("id") int id, Model model) {
        Optional<Menu> menu = menuService.findById(id);
        model.addAttribute("menu", menu);
        return "edit-menu";
    }
    @PostMapping("/menu/edit")
    public String editMenuSubmit(@ModelAttribute Menu menu) {
        menuService.save(menu);
        return "redirect:/menu";
    }
}
