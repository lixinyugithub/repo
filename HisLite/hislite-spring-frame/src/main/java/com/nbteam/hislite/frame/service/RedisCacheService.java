package com.nbteam.hislite.frame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheService {
	
    @Autowired
    private RedisTemplate redisTemplate;
	/***
	 * 
	* @Title: set 
	* @Description: 保存到缓存
	* @param   输入参数
	* @return void    返回类型 
	* @throws
	 */
    public void setValue(String key, Object value) {
    	redisTemplate.opsForValue().set(key, value);
    }
    
    /***
     * 
    * @Title: set 
    * @Description: 设置默认超时时间 已秒为单位
    * @param   输入参数
    * @return void    返回类型 
    * @throws
     */
    public void setValue(String key, Object value,long timeout) {
    	redisTemplate.opsForValue().set(key, value, timeout,TimeUnit.SECONDS);
    }
    /***
     * 
    * @Title: setExpire 
    * @Description: 设置数据超时时间
    * @param   输入参数
    * @return void    返回类型 
    * @throws
     */
    public void setExpire(String key,long timeout) {
    	redisTemplate.expire(key,  timeout,TimeUnit.SECONDS);
    }
    
    public Object  getValue(String key) {
    	return redisTemplate.opsForValue().get(key);
    }
    /***
     * 
    * @Title: delKey 
    * @Description: 根据key 删除缓存
    * @param   输入参数
    * @return void    返回类型 
    * @throws
     */
    public void  delKey(String key) {
    	redisTemplate.delete(key);
    }
    
    /***
     * 
    * @Title: getValue 
    * @Description: 强转为指定类型
    * @param   输入参数
    * @return T    返回类型 
    * @throws
     */
    public <T> T  getValue(String key,Class<T> clazz) {
    	return (T)redisTemplate.opsForValue().get(key);
    }

    public Object  getValue(String key, int timeout) {
        if (timeout > 0) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return redisTemplate.opsForValue().get(key);
    }

    /**
     *
     * @param key
     * @param liveTime
     * @return
     */
    public Long incr(String key, long liveTime) {
        RedisAtomicLong entityIdCounter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        Long increment = entityIdCounter.getAndIncrement();

        if ((null == increment || increment.longValue() == 0) && liveTime > 0) {//初始设置过期时间
            entityIdCounter.expire(liveTime, TimeUnit.SECONDS);
        }
        return increment;
    }
	
}
