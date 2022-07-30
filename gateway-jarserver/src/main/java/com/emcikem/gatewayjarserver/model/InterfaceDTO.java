package com.emcikem.gatewayjarserver.model;

import java.util.List;

/**
 * @author Emcikem
 * @create 2022/7/30
 * @desc
 */
public class InterfaceDTO {

    private String name;

    private Class<?> clz;

    private Integer methodType;

    private List<ModelDTO> requestDTOList;

    private ModelDTO responseDTO;
}
