package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.RoleDao;
import com.ssm.model.Role;
import com.ssm.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.roleDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Role record) {
		return this.roleDao.insert(record);
	}

	@Override
	public int insertSelective(Role record) {
		return this.roleDao.insertSelective(record);
	}

	@Override
	public Role selectByPrimaryKey(Integer id) {
		return this.roleDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Role record) {
		return this.roleDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Role record) {
		return this.roleDao.updateByPrimaryKey(record);
	}

}
