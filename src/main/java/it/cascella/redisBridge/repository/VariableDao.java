package it.cascella.redisBridge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class VariableDao {
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public VariableDao(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
    public void save(String key, String value) {
        System.out.println("[DEBUG] save VariableDao: " + key + " " + value);
        redisTemplate.opsForValue().set(key, value);
    }
    public String get(String key) {
        System.out.println("[DEBUG] get VariableDao: " + key);
        return redisTemplate.opsForValue().get(key);
    }
    public void delete(String key) {
        System.out.println("[DEBUG] del VariableDao: " + key);
        redisTemplate.delete(key);
    }
}
