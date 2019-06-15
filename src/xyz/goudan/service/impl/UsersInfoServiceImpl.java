package xyz.goudan.service.impl;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import xyz.goudan.mapper.UsersInfoMapper;
import xyz.goudan.pojo.UsersInfoPojo;
import xyz.goudan.service.UsersInfoService;

public class UsersInfoServiceImpl  implements UsersInfoService{

	private UsersInfoMapper usersInfoMapper;
	@Override
	public List showAllUsers() {
		return usersInfoMapper.showAllUser();
	}
	
	@Override
	public void deletePerson(String id) {
		usersInfoMapper.deletePerson(id);
	}
	@Override
	public void addPerson(UsersInfoPojo usersInfoPojo) {
		usersInfoMapper.insertPerson(usersInfoPojo);
	}
	
	@Override
	public UsersInfoPojo selectPersonByID(int id) {
		return usersInfoMapper.selectPersonByID(id);
	}
	
	@Override
	public void updatePerson(UsersInfoPojo usersInfoPojo) {
		usersInfoMapper.updatePerson(usersInfoPojo);
	}
	
	public UsersInfoMapper getUsersInfoMapper() {
		return usersInfoMapper;
	}
	public void setUsersInfoMapper(UsersInfoMapper usersInfoMapper) {
		this.usersInfoMapper = usersInfoMapper;
	}

	

	
	
}
