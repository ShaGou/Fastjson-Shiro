package xyz.goudan.realm;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import xyz.goudan.pojo.UsersPojo;
import xyz.goudan.service.impl.UsersLoginServiceImpl;


public class UsersRealm extends AuthorizingRealm{
	
	@Resource
	private UsersLoginServiceImpl usersLoginServiceImpl;
	
	public String getName(){
		return "usersRealm";
	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("进入授权流程");
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("进入认证流程");
		String principal = (String) token.getPrincipal();
		UsersPojo user=usersLoginServiceImpl.login(principal);
		SimpleAuthenticationInfo info=null;
		try{
			info=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
		}catch(Exception e){
		}
		return info;
	}
	
}
