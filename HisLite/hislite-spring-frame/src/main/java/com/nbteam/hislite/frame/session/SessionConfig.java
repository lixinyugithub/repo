package com.nbteam.hislite.frame.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.ConfigureRedisAction;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/****
 * 
 * <pre>类名: SessionConfig</pre>
 * <pre>描述: spring redis session 主要解决会话共享问题
 * //maxInactiveIntervalInSeconds为session过期时间，这里注意session过期时间配置在web.xml里面是不起作用的  </pre>
 */
@Configuration
//修改为配置文件启用@EnableRedisHttpSession(maxInactiveIntervalInSeconds = CommonConst.MAX_INACTIVEIN_TERVALIN_SECONDS)
public class SessionConfig {
	//如果服务器用的是云服务器，不加这个会报错  
    @Bean
    public static ConfigureRedisAction configureRedisAction() {
        return ConfigureRedisAction.NO_OP;
    }  
	/***
	 * 
	* @Title: connectionFactory 
	* @Description: 配置redis 连接
	* @param   输入参数
	* @return LettuceConnectionFactory    返回类型 
	* @throws
	 */
	/*@Bean
    public LettuceConnectionFactory connectionFactory() {
            return new LettuceConnectionFactory(); 
    }*/
	/****
	 * 
	* @Title: httpSessionStrategy 
	* @Description: 采用heda token 方式 覆盖cookie 方式
	* @param   输入参数
	* @return HttpSessionStrategy    返回类型 
	* @throws
	 */
    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    	// return new EtcHttpSessionStrategy();
    }
}
