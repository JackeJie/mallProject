package com.mallProject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mallProject.demo.entity.BBookinfo;
import com.mallProject.demo.service.BBookinfoService;
import com.mallProject.demo.util.ResponseMessage;

@Controller
public class BookController {
	
	
	@Autowired
	private BBookinfoService  bBookinfoService;
	
	//查询所有商品
	@RequestMapping(value="getAll.s")
	public String getAllBook(Model model) {
		List<BBookinfo> list=bBookinfoService.getBBookinfoAll();
		System.out.println(ResponseMessage.returnResponseMessageSucess(0, "成功", list));
		model.addAttribute("list", list);
		return "BookShow";
	}
	
	@RequestMapping("insert.s")
	public ResponseMessage<Object>  insertBook(BBookinfo record){
	       int sb=	bBookinfoService.insert(record);
	       if(sb<0) {
	    	   return ResponseMessage.returnResponseMessageError(sb, "添加失败");
	       }
		
		return ResponseMessage.returnResponseMessage(0, "添加成功");
	}
	
	@RequestMapping(value="selectOne.s")
	public String getOneBook(Integer id,Model model,BBookinfo bBookinfo) {
		System.out.println(id);
		 bBookinfo=  	bBookinfoService.selectByPrimaryKey(id);
		model.addAttribute("BBookinfo", bBookinfo);
		return "/page/selectOne";
	}
	

}
