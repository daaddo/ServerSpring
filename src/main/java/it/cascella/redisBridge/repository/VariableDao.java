package it.cascella.redisBridge.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public Map<String, Object> get() {
        System.out.println("[DEBUG] getting all VariableDao: ");

        // Ottieni tutte le chiavi da Redis
        Set<String> keys = redisTemplate.keys("*");

        Map<String, Object> entries = new HashMap<>();
        System.out.println("so dentro");

        if (keys != null) {
            for (String key : keys) {
                if (redisTemplate.type(key)!= DataType.STRING){
                    continue;
                }
                Object value = redisTemplate.opsForValue().get(key);

                if (value != null) {
                    entries.put(key, value);
                    System.out.println("[DEBUG] " + key + " " + value);
                } else {
                    System.out.println("[DEBUG] Chiave " + key + " non trovata.");
                }
            }
        } else {
            System.out.println("[DEBUG] Nessuna chiave trovata.");
        }

        return entries;
    }
    public void delete(String key) {
        System.out.println("[DEBUG] del VariableDao: " + key);
        redisTemplate.delete(key);
    }
}
