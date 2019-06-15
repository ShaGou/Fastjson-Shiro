package xyz.goudan.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import xyz.goudan.utils.Utils;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import xyz.goudan.pojo.UsersInfoPojo;
import xyz.goudan.service.impl.UsersInfoServiceImpl;


@Controller
public class UserController {
	
	@Resource
	private UsersInfoServiceImpl usersInfoServiceImpl;
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req) {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean rememberMe = req.getParameter("rememberMe") == null ? false : req.getParameter("rememberMe").equals("on") ? true : false;
		System.out.println(username+"***"+password+"***"+rememberMe);
		Subject loginSubject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		token.setRememberMe(rememberMe);
		try{
			loginSubject.login(token);
			if(loginSubject.isAuthenticated()){
				req.getSession().setAttribute("username", username);
				return "frame";
			}
		}catch(Exception e){
		}
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest req) {
		WebApplicationContext wac=WebApplicationContextUtils.getRequiredWebApplicationContext(req.getServletContext());
		String[] names = wac.getBeanDefinitionNames();
		for (String string : names) {
			System.out.println(string);
		}
		return "frame";
	}
	
	@RequestMapping(value = "/main")
	public String main(Map<String, Object> map) {
		map.put("personlist", usersInfoServiceImpl.showAllUsers());
		return "main";
	}
	
	@RequestMapping(value = "/deletePersonById")
	public String addperson(HttpServletRequest req,String id) {
		usersInfoServiceImpl.deletePerson(id);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/doupdate")
	public String doupdate(@RequestParam(value = "id") int id, Model model) {
		model.addAttribute("person",usersInfoServiceImpl.selectPersonByID(id));
		return "editpage";
	}
	
	@RequestMapping(value = "/addperson")
	public String addperson(HttpServletRequest req) {
		return "savepage";
	}
	
	
	@RequestMapping(value = "/saveperson")
	public String saveperson(@RequestBody String obj){
		JSONObject json = JSONObject.parseObject(obj,Feature.SupportNonPublicField);
		UsersInfoPojo person=Utils.Json2UsersInfoPojo(json);
		usersInfoServiceImpl.addPerson(person);
		return "redirect:main";
	}
	@RequestMapping(value = "/updateperson")
	public String updateperson(@RequestBody String obj) {
		System.err.println(obj);
		JSONObject json = JSONObject.parseObject(obj,Feature.SupportNonPublicField);
		UsersInfoPojo person=Utils.Json2UsersInfoPojo(json);
		System.out.println(person);
		usersInfoServiceImpl.updatePerson(person);
		return "redirect:main";
	}
	
	
	
	

}
