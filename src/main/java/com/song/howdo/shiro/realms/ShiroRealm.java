package com.song.howdo.shiro.realms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.howdo.model.User;
import com.song.howdo.service.UserService;

public class ShiroRealm extends AuthorizingRealm {
	
	@Autowired
	private UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		//1.把 AuthenticationToken 转化成 UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.从 UsernamePasswordToken中获取 username
		String username = upToken.getUsername();
		//3.从数据库中查询 username对应的记录
		//4.若用户不存在则抛出 UnknownAccountException 异常
		//5.根据用户信息的情况，决定是否需要抛出其他的异常 AuthenticationException
		//6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
		//以下信息是从数据库中获取的.
		//1). principal: 认证的实体信息. 可以是 username, 也可以是数据表对应的用户的实体类对象.
		Object principal = username;
		//2). credentials: 密码.
		Object credentials = null;
		User user = userService.queryUserByAccount(username);
		if(user != null){
			credentials = user.getPassword();
		}else{
			throw new UnknownAccountException("用户不存在");
		}
		//3). realmName: 当前 realm 对象的 name. 调用父类的 getName() 方法即可
		String realmName = getName();
		//4). 盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}
	
	/**
	 * 非盐值加密
	 * @param credentials
	 * @return
	 */
	public Object encrypt(Object credentials) {
		String hashAlgorithmName = "MD5";
		Object salt = null;
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result;
	}

	/**
	 * 盐值加密
	 * @param credentials
	 * @return
	 */
	public static Object encryptBySalt(Object credentials, String bySalt) {
		String hashAlgorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(bySalt);
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
		return result;
	}
	
	public static void main(String[] args) {
		Object result = encryptBySalt("123456", "user");
		System.out.println(result);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//1. 从 PrincipalCollection 中来获取登录用户的信息
		Object principal = principals.getPrimaryPrincipal();

		//2. 利用登录的用户的信息来用户当前用户的角色或权限(可能需要查询数据库)
		Set<String> roles = new HashSet<String>();
//		roles.add("user");
//		if("admin".equals(principal)){
//			roles.add("admin");
//		}
		String account = (String) principal;
		List<String> userRoles = userService.queryUserRoles(account);
		for(String s : userRoles){
			roles.add(s);
		}

		//3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

		//4. 返回 SimpleAuthorizationInfo 对象.
		return info;
	}

}
