package com.macro.cloud.component;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * Jwt内容增强器, 这个是用来在 jwt中 存放一些简单信息,比如,用户拥有的角色, 比如工号,会员id
 * Created by macro on 2019/10/8.
 */
public class JwtTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> info = new HashMap<>();
        info.put("enhance", "enhance info");
        //jwt中添加用户id ,用户名, 用户拥有的角色list, 进而知道拥有的权限,进而知道是否有权限进行某一操作
        //info.put("roles", JSONUtil.toJsonStr(roles))
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
