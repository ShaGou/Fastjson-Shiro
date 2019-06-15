package xyz.goudan.service;

import java.util.List;

import xyz.goudan.pojo.UsersPojo;

public interface UsersLoginService {
	UsersPojo login(String username);
}
