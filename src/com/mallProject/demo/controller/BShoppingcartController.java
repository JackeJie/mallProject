package com.mallProject.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mallProject.demo.service.BShoppingcartService;
@RequestMapping("Shoppingcart")
@Controller
public class BShoppingcartController {
	
	@Autowired
	private BShoppingcartService service;
	
	@RequestMapping(value="count.s")
	public String getCount(Model model) {
	  int count=	 service.getCount();
		model.addAttribute("count", count);
		return "resouce/head";
	}
	  
	

}
