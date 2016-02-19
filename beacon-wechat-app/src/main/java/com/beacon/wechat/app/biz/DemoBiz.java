package com.beacon.wechat.app.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beacon.wechat.api.service.UserService;

@Service("demoBiz")
public class DemoBiz {
	@Autowired
	UserService userService;
	public String getName(long id) {
		return userService.findUserById(id).getName();
	}
}
