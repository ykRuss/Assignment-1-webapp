package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.model.Brand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ItemController {
    @GetMapping("/")
    public String home() {
        return "index"; // This maps to src/main/resources/templates/index.html
    }

    @GetMapping("/add-item")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("brands", Brand.values());
        return "add-item";
    }

    @PostMapping("/add-item")
    public String addItem(@Valid @ModelAttribute("item") Item item, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("brands", Brand.values());
            return "add-item";
        }
        // Process the item (e.g., save to database)
        return "redirect:/add-item?success";
    }
}
