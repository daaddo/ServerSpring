package it.cascella.redisBridge.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    public Map<Object,Object> get() {
        System.out.println("[DEBUG] getting all VariableDao: " );
        //mappa chiave valore
        Map<Object, Object> entries = redisTemplate.opsForValue().getOperations().boundHashOps("key").entries();
        return entries;
    }
    public void delete(String key) {
        System.out.println("[DEBUG] del VariableDao: " + key);
        redisTemplate.delete(key);
    }
}
