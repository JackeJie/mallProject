package com.mallProject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mallProject.demo.entity.BBookinfo;
import com.mallProject.demo.service.BBookinfoService;

@RestController
public class BookController {
	
	
	@Autowired
	private BBookinfoService  bBookinfoService;
	
	@RequestMapping("getall.s")
	@ResponseBody
	public List<BBookinfo> getAllBook() {
		return bBookinfoService.getBBookinfoAll();
	}
	

}
