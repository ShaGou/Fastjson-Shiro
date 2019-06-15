package xyz.goudan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import xyz.goudan.mapper.UsersLoginMapper;
import xyz.goudan.pojo.UsersPojo;
import xyz.goudan.service.UsersLoginService;

@Component
public class UsersLoginServiceImpl implements UsersLoginService{

	@Resource
	private UsersLoginMapper usersLoginMapper;
	
	
	public UsersPojo login(String username) {
		return usersLoginMapper.login(username);
	}

	public UsersLoginMapper getUsersLoginMapper() {
		return usersLoginMapper;
	}

	public void setUsersLoginMapper(UsersLoginMapper usersLoginMapper) {
		this.usersLoginMapper = usersLoginMapper;
	}

}
