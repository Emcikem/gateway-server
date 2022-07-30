package com.emcikem.gatewayjarserver.entity;

import lombok.*;

import java.util.Date;

/**
 * @author Emcikem
 * @create 2022/7/30
 * @desc
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InterfaceDO {

    private Long id;

    private String interfaceName;

    private String interfacePath;

    private String appKey;

    private String appVersion;

    private String method;

    private String updateBy;

    private Date addTime;

    private Date updateTime;
}
