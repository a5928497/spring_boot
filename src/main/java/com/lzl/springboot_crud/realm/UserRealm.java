package com.lzl.springboot_crud.realm;

import com.lzl.springboot_crud.entity.User;
import com.lzl.springboot_crud.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    //用于授权的方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //1. 从 principalCollection 中来获取登录用户的信息
        Object principal = principalCollection.getPrimaryPrincipal();
        //2. 利用登录的用户的信息来当前用户的角色或权限(可能需要查询数据库)
        User user = userService.getByUsername((String) principal);
        Set<String> roles = new HashSet<>();
        roles.add("user");
        if("admin".equals(user.getRole().getRoleName())){
            roles.add("admin");
        }

        //3. 创建 SimpleAuthorizationInfo, 并设置其 reles 属性.
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        //4. 返回 SimpleAuthorizationInfo 对象.
        return info;
    }
    //用于认证的方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
        //3. 从数据库获取username准备进行比对
        String _username = userService.checkUsername(username);
//      // 4. 异常用户处理
//        if("unknown".equals(username)){
//            throw new UnknownAccountException("用户不存在!");
//        }
//
//        //5. 根据用户信息的情况, 决定是否需要抛出其他的 AuthenticationException 异常.
//        if("monster".equals(username)){
//            throw new LockedAccountException("用户被锁定");
//        }
        //6. 根据用户的情况, 来构建 AuthenticationInfo 对象并返回. 通常使用的实现类为: SimpleAuthenticationInfo
        Object principal = username;
        Object credentials = upToken.getCredentials();
        String realmName = getName();
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;
    }
}
