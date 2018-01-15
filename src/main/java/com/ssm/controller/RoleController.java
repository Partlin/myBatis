package com.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.Role;
import com.ssm.service.RoleService;
import com.ssm.util.JsonUtil;

@Controller
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	/**
	 * 通过@RequestParam获取请求参数
	 * 
	 */
	@RequestMapping("/RoleInfo")
	public void RoleInfo(@RequestParam("id") int id,HttpServletResponse response){
		Role data= new Role();
		data = roleService.selectByPrimaryKey(id);
		String jsondata=JsonUtil.toJSONString(data);
		JsonUtil.sendjson(jsondata, response);
	}
	/**
	 * 通过HttpServletRequest获取请求参数
	 * 
	 */
	@RequestMapping("/RoleInfo1")
	public void RoleInfo1(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		Role data= new Role();
		data = roleService.selectByPrimaryKey(id);
		String jsondata=JsonUtil.toJSONString(data);
		JsonUtil.sendjson(jsondata, response);
	}
	/**
	 * 通过@ResponseBody返回JSON数据
	 * 
	 */
	@RequestMapping("/RoleInfo2")
	public @ResponseBody Role RoleInfo2(HttpServletRequest request,HttpServletResponse response){
		int id = Integer.parseInt(request.getParameter("id"));
		Role data= new Role();
		data = roleService.selectByPrimaryKey(id);
		return data;
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
