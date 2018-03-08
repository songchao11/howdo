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
		//1.�� AuthenticationToken ת���� UsernamePasswordToken
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		//2.�� UsernamePasswordToken�л�ȡ username
		String username = upToken.getUsername();
		//3.�����ݿ��в�ѯ username��Ӧ�ļ�¼
//		System.out.println("�����ݿ��л�ȡusername��"+username+"����Ӧ���û���Ϣ");
		//4.���û����������׳� UnknownAccountException �쳣
//		if("unknown".equals(username)){
//			throw new UnknownAccountException("�û�������");
//		}
		//5.�����û���Ϣ������������Ƿ���Ҫ�׳��������쳣 AuthenticationException
//		if("monster".equals(username)){
//			throw new LockedAccountException("�û�������");
//		}
		//6. �����û������, ������ AuthenticationInfo ���󲢷���. ͨ��ʹ�õ�ʵ����Ϊ: SimpleAuthenticationInfo
		//������Ϣ�Ǵ����ݿ��л�ȡ��.
		//1). principal: ��֤��ʵ����Ϣ. ������ username, Ҳ���������ݱ��Ӧ���û���ʵ�������. 
		Object principal = username;
		//2). credentials: ����. 
		Object credentials = null; //"fc1709d0a95a6be30bc5926fdb7f22f4";
//		if("admin".equals(username)){
//			credentials = "038bdaf98f2037b31f1e75b5b4c9b26e";
//		}else if("user".equals(username)){
//			credentials = "098d2c478e9c11555ce2823231e02ec1";
//		}
		User user = userService.queryUserByAccount(username);
		if(user != null){
			credentials = user.getPassword();
		}else{
			throw new UnknownAccountException("�û�������");
		}
		//3). realmName: ��ǰ realm ����� name. ���ø���� getName() ��������
		String realmName = getName();
		//4). ��ֵ
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		SimpleAuthenticationInfo info = null; //new SimpleAuthenticationInfo(principal, credentials, realmName);
		info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
		return info;
	}
	
	/**
	 * ������ܷ���
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
	 * ������ܷ���
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
		//1. �� PrincipalCollection ������ȡ��¼�û�����Ϣ
		Object principal = principals.getPrimaryPrincipal();
		
		//2. ���õ�¼���û�����Ϣ���û���ǰ�û��Ľ�ɫ��Ȩ��(������Ҫ��ѯ���ݿ�)
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
		
		//3. ���� SimpleAuthorizationInfo, �������� reles ����.
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		
		//4. ���� SimpleAuthorizationInfo ����. 
		return info;
	}

}
