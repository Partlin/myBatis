package com.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssm.model.Role;
import com.ssm.service.RoleService;
import com.ssm.util.JsonUtil;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/RoleInfo")
	public void RoleInfo(@RequestParam("id") int id,HttpServletResponse response){
		Role data= new Role();
		data = roleService.selectByPrimaryKey(id);
		String jsondata=JsonUtil.toJSONString(data);
		JsonUtil.sendjson(jsondata, response);
	}
	
}
