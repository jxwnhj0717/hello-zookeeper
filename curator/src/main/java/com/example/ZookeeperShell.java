package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.zookeeper.config.LeaderInitiatorFactoryBean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class ZookeeperShell {

    @Autowired
    private LeaderInitiatorFactoryBean leaderInitiatorFactoryBean;
    @Autowired
    private LeaderListener leaderListener;

    @ShellMethod("开始选举")
    public void startElection() {
        leaderInitiatorFactoryBean.getObject().start();
    }

    @ShellMethod("退出选举")
    public void stopElection() {
        leaderInitiatorFactoryBean.getObject().stop();
    }

    @ShellMethod("是否leader")
    public void isLeader() {
        System.out.println(leaderListener.isLeader());
    }

}
