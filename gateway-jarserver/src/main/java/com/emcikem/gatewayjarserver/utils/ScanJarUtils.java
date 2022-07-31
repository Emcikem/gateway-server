package com.emcikem.gatewayjarserver.utils;

import com.emcikem.gatewayjarserver.entity.AppBaseInfoDO;
import com.emcikem.gatewayjarserver.model.ModelDTO;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Emcikem
 * @create 2022/7/30
 * @desc 扫描jar包
 */
public class ScanJarUtils {


    public static ModelDTO scanClass(Class<?> clazz) {
        ModelDTO modelDTO = ModelDTO.builder()
                .name(clazz.getSimpleName())
                .clz(clazz)
                .childList(null)
                .build();
        if (isPrimitive(clazz)) {
            return modelDTO;
        }
        List<ModelDTO> modelDTOList = new ArrayList<>();
        AtomicInteger index = new AtomicInteger();
        modelDTO.setChildList(modelDTOList);
        Arrays.stream(clazz.getDeclaredFields()).forEach(x -> {
            ModelDTO child = scanClass(x.getType());
            child.setStep(index.getAndIncrement());
            modelDTOList.add(child);
        });
        return modelDTO;
    }


    private static boolean isPrimitive(Class<?> clazz) {
        if (clazz.isPrimitive()) {
            return true;
        }
        try {
            return ((Class<?>) clazz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ModelDTO modelDTO = scanClass(AppBaseInfoDO.class);
        System.out.println(modelDTO);

    }
}
