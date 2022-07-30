package com.emcikem.gatewayjarserver.entity;

import lombok.*;

import java.util.Date;

/**
 * @author Emcikem
 * @create 2022/7/30
 * @desc request and response
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModelDO {

    private Long id;

    private Long appId;

    private String modelName;

    private String modelPath;

    /**
     * 参数的顺序
     */
    private int step;

    private String updateBy;

    private Date addTime;

    private Date updateTime;
}
