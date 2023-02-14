package com.example.paymentservice.controller;

import com.example.paymentservice.ds.Customer;
import com.example.paymentservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/payment")
public class CustomerController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/register")
    public String home(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("success", model.containsAttribute("success"));
        return "customer-form";
    }

    @PostMapping("/register")
    public String register(Customer customer, RedirectAttributes redirectAttributes){
        accountService.register(customer);
        redirectAttributes.addFlashAttribute("success", true);
        return "redirect:/payment/register";
    }
}
