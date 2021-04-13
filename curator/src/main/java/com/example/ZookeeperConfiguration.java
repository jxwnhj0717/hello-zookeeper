package com.example;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.zookeeper.config.CuratorFrameworkFactoryBean;
import org.springframework.integration.zookeeper.config.LeaderInitiatorFactoryBean;
import org.springframework.integration.zookeeper.metadata.ZookeeperMetadataStore;

@Configuration
public class ZookeeperConfiguration {

    @Bean
    public ZookeeperProperties getZookeeperProperties() {
        return new ZookeeperProperties();
    }

    @Bean
    public CuratorFrameworkFactoryBean getCuratorFrameworkFactoryBean(ZookeeperProperties properties) {
        return new CuratorFrameworkFactoryBean(properties.getConnectString());
    }

    @Bean
    public ZookeeperMetadataStore getZookeeperMetadataStore(CuratorFramework client, ZookeeperProperties properties, NodeListener listener) {
        ZookeeperMetadataStore store = new ZookeeperMetadataStore(client);
        store.setRoot(properties.getCrudPath());
        store.addListener(listener);
        return store;
    }

    @Bean
    public LeaderInitiatorFactoryBean leaderInitiator(CuratorFramework client, ZookeeperProperties properties) {
        return new LeaderInitiatorFactoryBean()
                .setClient(client)
                .setPath(properties.getLeaderPath())
                .setRole("leader");
    }

}
