package org.escort.client.registry;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Shoukai Huang
 * @Date: 2019/8/15 18:50
 */
@Data
public class RegisterInfo implements Serializable {

    public RegisterInfo() {
    }

    public RegisterInfo(String serviceName, String ipAddress, Integer port) {
        this.serviceName = serviceName;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务描述（可以为Null）
     */
    private String serviceDesc;
    /**
     * 服务地址
     */
    private String ipAddress;
    /**
     * 服务TC通讯端口
     */
    private Integer port;
}
