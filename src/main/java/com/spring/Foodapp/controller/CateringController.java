package com.spring.Foodapp.controller;

import com.spring.Foodapp.model.Catering;
import com.spring.Foodapp.service.CateringService;
import com.spring.Foodapp.service.CustomUserDetails;
import com.spring.Foodapp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CateringController {

    @Autowired
    CateringService cateringService;

    @Autowired
    MenuService menuService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Catering> cateringList = cateringService.getAll();
        model.addAttribute("cateringList", cateringList);
        return "dashboard";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("catering", new Catering());
        return "create";
    }

    @PostMapping("/create")
    public String createSubmit(@ModelAttribute Catering catering, Model model) {
        cateringService.save(catering);
        return "redirect:/dashboard";
    }
    @GetMapping("/catering/edit/{id}")
    public String editCatering(@PathVariable("id") int id, Model model) {
        Optional<Catering> catering = cateringService.findById(id);
        List<String> menus = menuService.findAllMenuNames();
        model.addAttribute("menus", menus);
        model.addAttribute("catering", catering);
        return "edit-catering";
    }
    @PostMapping("/catering/edit")
    public String editCateringSubmit(@ModelAttribute Catering catering) {
        cateringService.save(catering);
        return "redirect:/dashboard";
    }
    @GetMapping("/catering/delete/{id}")
    public String deleteCatering(@PathVariable("id") int id, Model model){
        cateringService.deleteById(id);
        return "redirect:/dashboard";
    }
    @GetMapping("/dashboard/search")
    public String searchCaterings(@RequestParam("query") String query, Model model) {
        List<Catering> filteredList = cateringService.findCateringsByName(query);
        model.addAttribute("cateringList", filteredList);
        return "dashboard";
    }

    @GetMapping("/account")
    public String account(Model model, @AuthenticationPrincipal CustomUserDetails customUserDetails) {
        int userId = customUserDetails.getId();
        return "account";
    }
}
