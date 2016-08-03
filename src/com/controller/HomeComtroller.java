package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeComtroller {

	@RequestMapping("/home")
	public String index() {
		return "home";
	}
}
