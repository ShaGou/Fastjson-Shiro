package xyz.goudan.utils;

import com.alibaba.fastjson.JSONObject;

import xyz.goudan.pojo.UsersInfoPojo;

public class Utils {
	public static UsersInfoPojo Json2UsersInfoPojo(JSONObject json){
		UsersInfoPojo person=new UsersInfoPojo();
		person.setId(json.getString("id"));
		person.setAddress(json.getString("address"));
		person.setIdCard(json.getString("idCard"));
		person.setName(json.getString("name"));
		person.setPhone(json.getString("phone"));
		return person;
	}
}
