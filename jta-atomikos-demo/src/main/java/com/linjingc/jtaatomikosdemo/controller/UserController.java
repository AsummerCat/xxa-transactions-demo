package com.linjingc.jtaatomikosdemo.controller;

import com.linjingc.jtaatomikosdemo.service.JTAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private JTAService jtaService;


	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		jtaService.insert();
		return "保存成功";
	}


}
