package com.almcalle.suyapa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {


	    @GetMapping("/")
	    public String greetingForm(Model model) {
//	        model.addAttribute("greeting", new Greeting());
	        return "index";
	    }
}