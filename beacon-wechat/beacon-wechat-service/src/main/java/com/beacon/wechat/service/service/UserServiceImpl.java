/**  
 * @Title: UserService.java
 * @Prject: InternalService
 * @Package: io.springcat.internal.service.impl
 * @Description: TODO
 * @author: adampeng  
 * @date: 2015年2月26日 下午2:35:32
 * @version: V1.0  
 */
package com.beacon.wechat.service.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.beacon.wechat.api.model.User;
import com.beacon.wechat.api.service.UserService;
import com.beacon.wechat.service.dao.UserDao;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @author: adampeng
 * @date: 2015年2月26日 下午2:35:32
 */
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDAO;

	public User findUserById(Long id) {
		return userDAO.get(id);
	}
}
