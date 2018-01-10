package com.ssm.controller;

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
	
	@RequestMapping("/RoleInsert")
	public void RoleInsert(@RequestParam("id") int id,@RequestParam("roleName") String roleName,
			@RequestParam("note") String note,HttpServletResponse response){
		Role data= new Role();
		data.setId(id);
		data.setRoleName(roleName);
		data.setNote(note);
		try {
			roleService.insertSelective(data);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "error!";
			JsonUtil.sendjson(err, response);
			return;
		}
		
		String jsondata="success:"+JsonUtil.toJSONString(data);
		JsonUtil.sendjson(jsondata, response);
	}
	
}
