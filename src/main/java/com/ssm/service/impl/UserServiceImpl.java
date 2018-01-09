package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import com.ssm.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.userDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(User record) {
		return this.userDao.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return this.userDao.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		return this.userDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return this.userDao.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return this.userDao.updateByPrimaryKey(record);
	}

}
