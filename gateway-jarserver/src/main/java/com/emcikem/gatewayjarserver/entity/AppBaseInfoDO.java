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
public class AppBaseInfoDO {

    private Long id;

    /**
     * appKey
     */
    private String appKey;

    /**
     * app的介绍
     */
    private String introduction;

    /**
     * jar包版本
     */
    private String jarVersion;

    private String updateBy;

    private Date addTime;

    private Date updateTime;
}
