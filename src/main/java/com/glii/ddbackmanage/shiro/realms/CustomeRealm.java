package com.glii.ddbackmanage.shiro.realms;

import com.glii.ddbackmanage.entity.User;
import com.glii.ddbackmanage.service.UserService;
import com.glii.ddbackmanage.utils.ApplicationContextUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.util.ObjectUtils;

//自定义realm
public class CustomeRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限认证");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登陆认证");

        String principal = (String) authenticationToken.getPrincipal();

        UserService userService =(UserService) ApplicationContextUtil.getBean("userServiceImpl");
        User user = userService.findByUsername(principal);
        if (!ObjectUtils.isEmpty(user)) {
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), this.getName());
        }
        return null;
    }
}
