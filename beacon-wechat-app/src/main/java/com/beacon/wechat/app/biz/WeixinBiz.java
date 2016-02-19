package com.beacon.wechat.app.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

@Service("weixinBiz")
public class WeixinBiz {
	@Autowired
	protected WxMpConfigStorage wxMpConfigStorage;
	@Autowired
	protected WxMpService wxMpService;
	@Autowired
	protected WxMpMessageRouter wxMpMessageRouter;
	public String oauth2buildAuthorizationUrl(){
		return wxMpService.oauth2buildAuthorizationUrl(WxConsts.OAUTH2_SCOPE_USER_INFO, null);
	}
	public WxMpOAuth2AccessToken oauth2getAccessToken(String code){
		try {
			return wxMpService.oauth2getAccessToken(code);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return null;
	}
	public WxMpUser oauth2getUserInfo(WxMpOAuth2AccessToken wxMpOAuth2AccessToken){
		try {
			return wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
		return null;
	}
}
