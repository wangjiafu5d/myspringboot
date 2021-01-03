package com.chuan.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chuan.myspringboot.bean.ManageRcord;
import com.chuan.myspringboot.service.RecordService;
@Controller
public class Home {
	@Autowired
	RecordService recordService;
	 @RequestMapping("/hello")
	 @ResponseBody
	    public String index() {
	        return "Hello World";
	    }
	 @RequestMapping("/getrecord")
	 @ResponseBody
	    public List<ManageRcord> getecord() {
	        return recordService.get();
	    }
	
	 @RequestMapping("/login")
	    public String login() {		 
	        return "login";
	    }
}
