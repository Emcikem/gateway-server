package com.emcikem.gateway.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.UUID;

/**
 * @author Emcikem
 * @create 2022/7/16
 */
public class RedisUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisUtils.class);

    private final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public boolean lock(String key, Long timeoutMills, int keyExpireSecond) {
        try {
            LOCAL.set(UUID.randomUUID().toString());
            long start = System.currentTimeMillis();
            boolean result;
            ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
            while (!(result = Boolean.TRUE.equals(opsForValue.setIfAbsent(key, LOCAL.get(), Duration.ofSeconds(keyExpireSecond))))
                    && timeoutMills != null && (System.currentTimeMillis() - start) < timeoutMills) {
                Thread.sleep(10);
            }
            return result;
        } catch (Exception e) {
            LOGGER.error("tryLock fail,key: {}", key, e);
            return true;
        }
    }


    public boolean unLock(String key) {
        try {
            if (StringUtils.isBlank(LOCAL.get())) {
                return false;
            }
            return true;
//            return redisTemplate.opsForValue().
        } catch (Exception e) {
            LOGGER.error("unLock fail,key:{}", key, e);
            return false;
        } finally {
            LOCAL.remove();
        }
    }



    /**
     * string-get
     */
    public String get(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        return null;
    }

    /**
     * string-set
     */
    public String set(String key, String value, int expire) {
        return null;
    }

    /**
     * string-incr
     */
    public String incr(String key) {
        return null;
    }

    /**
     * hash-set
     */
    public String hset(String hKey, String key, String value) {
        return null;
    }

}
