package it.cascella.redisBridge.controllers;

import it.cascella.redisBridge.repository.VariableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private final VariableDao variableDao;

    @Autowired
    public RedisController(VariableDao variableDao) {
        this.variableDao = variableDao;
    }
    //ex http://localhost:8080/redis/save/?key=prova&value=prova
    @PostMapping("/save")
    public void save(@RequestParam("key") String key, @RequestParam("value") String value) {
        variableDao.save(key, value);
    }
    @GetMapping("/{key}")
    public String get(@PathVariable String key) {
        return variableDao.get(key);
    }

    @DeleteMapping("/{key}")
    public void delete(@PathVariable String key) {
         variableDao.delete(key);
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong!!!";
    }
}
