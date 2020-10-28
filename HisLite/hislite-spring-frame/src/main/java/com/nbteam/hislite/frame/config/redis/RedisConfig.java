package com.nbteam.hislite.frame.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

/**
 * 
 * <pre>类名: RedisConfig</pre>
 * <pre>描述: 自动缓存时用到</pre>
 */
@Configuration
@EnableCaching
//属性不存在默认设置 true
public class RedisConfig extends CachingConfigurerSupport {
	
    @Value("${server.session.timeout}")
    private Integer springSessionTimeout; //会话超时时间
    /***
     * key 生产方式
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                	sb.append("$");
                    sb.append(null == obj ? "":obj.toString());
                }
                return sb.toString();
            }
        };
    }
    /*****
     * 
    * @Title: cacheManager 
    * @Description: 缓存管理类
    * @return CacheManager    返回类型
    * @throws
     */
    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间 半小时的超时时间
        rcm.setDefaultExpiration(springSessionTimeout/6);//设置为会话时间的1/3
        return rcm;
    }
    /***
     * 
    * @Title: redisTemplate 
    * @Description: 序列化方案 
    * @return RedisTemplate<String,String>    返回类型
    * @throws
     */
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        StringRedisTemplate template = new StringRedisTemplate(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

}
