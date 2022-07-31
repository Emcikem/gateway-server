package com.emcikem.gatewayjarserver.model;

import lombok.*;

import java.util.List;

/**
 * @author Emcikem
 * @create 2022/7/30
 * @desc
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO {

    private String name;

    private Class<?> clz;

    private int step;

    List<ModelDTO> childList;

}
