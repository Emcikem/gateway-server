package com.emcikem.gateway.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author Emcikem
 * @create 2022/7/22
 * @desc
 */
@Slf4j
public class HTTPUtils {

    @Resource
    private RestTemplate restTemplate;

    public <T> T get(String url, Map<String, String> prams, Class<T> clz) {
        try {
            ResponseEntity<T> entity = restTemplate.getForEntity(url, clz);
            if (HttpStatus.OK.equals(entity.getStatusCode())) {
                return entity.getBody();
            }
        } catch (Exception e) {
            log.error("get fail:", e);
            return null;
        }
        return null;
    }

    public <T> T get(String url, Class<T> clz, Object...uriVariables) {
        try {
            restTemplate.getForEntity(url, clz, uriVariables);
        } catch (Exception e) {
            log.error("get fail:", e);
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        cal("http://localhost:8080/aa?name=", "name", "age");
    }

    public static void cal(String url, Object...uriVariables) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class, uriVariables);
            System.out.println(forEntity);
        } catch (Exception e) {
            log.error("get fail:", e);
        }
    }
}
