package xyz.goudan.service;

import java.util.List;

import xyz.goudan.pojo.UsersInfoPojo;

public interface UsersInfoService {
	List<UsersInfoPojo> showAllUsers();
	UsersInfoPojo selectPersonByID(int id);
	void deletePerson(String id);
	void addPerson(UsersInfoPojo usersInfoPojo);
	void updatePerson(UsersInfoPojo usersInfoPojo);
}
