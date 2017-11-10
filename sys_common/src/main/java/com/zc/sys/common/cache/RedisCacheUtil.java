package com.zc.sys.common.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.zc.sys.common.util.serialize.SerializeUtil;
/**
 * redis-client
 * @author zp 
 * @version 0.0.1
 * @since 2017年7月6日
 */
@Component
public class RedisCacheUtil {

    @Autowired
    JedisPool jedisPool;
    private static final int time = 60 * 60 * 24;

    /**
     * 设置缓存
     * @param key
     * @param code
     */
    public void setCode(String key, Object value) {
        this.setCode(key, value, time);
    }
    
    /**
     * 设置缓存
     * @param key
     * @param code
     * @param time
     */
    public void setCode(String key, Object value,int time) {
    	Jedis jedis = this.jedisPool.getResource();
        try {
            jedis.set(key.getBytes(), SerializeUtil.serialize(value));
            jedis.expire(key, time);
        } finally {
            jedis.close();
        }
    }
    
    /**
     * 获取缓存数据
     * @param key
     * @return
     */
    @SuppressWarnings("unchecked")
	public <T> T getCache(String key,Class<T> clazz){
    	Jedis jedis = jedisPool.getResource();
    	try {
            return (T)SerializeUtil.unserialize(jedis.get(key.getBytes()));
        } finally {
            jedis.close();
        }
    }
    
    /**
     * 删除缓存数据
     * @param key
     */
    public void delCode(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.del(key.getBytes());
        jedis.close();
    }
}
