package xyz.goudan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.goudan.pojo.UsersInfoPojo;

public interface UsersInfoMapper {
	@Select("select * from person")
	List<UsersInfoPojo> showAllUser();
	
	@Select("select * from person where id=#{id}")
	UsersInfoPojo selectPersonByID(int id);
	
	@Delete("delete from person where id=#{id} ")
	void deletePerson(String id);
	
	@Insert("insert into person values(default,#{usersInfoPojo.address},#{usersInfoPojo.idCard},#{usersInfoPojo.name},#{usersInfoPojo.phone})")
	void insertPerson(@Param("usersInfoPojo")UsersInfoPojo usersInfoPojo);
	
	@Update("update person set address=#{usersInfoPojo.address},idCard=#{usersInfoPojo.idCard},name=#{usersInfoPojo.name},phone=#{usersInfoPojo.phone} where id=#{usersInfoPojo.id}")
	void updatePerson(@Param("usersInfoPojo")UsersInfoPojo usersInfoPojo );
}
