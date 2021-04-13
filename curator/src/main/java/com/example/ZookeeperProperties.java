package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("zookeeper")
public class ZookeeperProperties {
    private String connectString;
    private String leaderPath;
    private String crudPath;
}
