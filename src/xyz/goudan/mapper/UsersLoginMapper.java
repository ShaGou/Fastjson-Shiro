package xyz.goudan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.goudan.pojo.UsersPojo;

public interface UsersLoginMapper {
	
	@Select("select * from users where username=#{username}")
	UsersPojo login(String username);
}
