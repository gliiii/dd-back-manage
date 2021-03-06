package com.glii.ddbackmanage.config;

import com.glii.ddbackmanage.shiro.realms.CustomeRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        //配置系统公共资源
        Map<String,String> map = new HashMap<String,String>();

        map.put("/user/login","anon");//anon 设置为公共资源  放行资源放在下面
        map.put("/user/getImage","anon");
        map.put("/**","authc");//authc 请求这个资源需要认证和授权
        //默认认证界面路径
        shiroFilterFactoryBean.setLoginUrl("/loginview");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);



        return shiroFilterFactoryBean;
    }


    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm );
        return defaultWebSecurityManager;
    }

    //自定义realm
    @Bean
    public Realm getRealm() {
        CustomeRealm customeRealm = new CustomeRealm();

        //


        return customeRealm;
    }
}
