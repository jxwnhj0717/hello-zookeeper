# Zookeeper

## Overview

分布式协调服务，可以实现服务间的状态同步、配置管理、命名和分组。

1. 设计目标：简单的、集群的、有序的、快速的。
2. 数据模型和分层命名空间：类似文件系统，不同的是每个节点既可以包含数据，同时可以包含子节点。也就是既是file，又是directory。
3. 节点和临时节点：保存数据、版本、时间、访问控制。session end时临时节点移除。
4. 保证：顺序一致、原子性、统一视图、可靠性、及时性。
5. 简单的API：create/delete/exists/get data/set data/get children/sync。
6. 实现：先写日志，再写内存。查询从client连接的那个server获取，修改交给leader server处理。采用leader-follows结构。
7. 性能：至少3节点，5节点性能有显著提升，考虑有服务挂掉的情况，可以使用7节点。
8. 可靠性：follow节点失败并迅速恢复，不影响zookeeper集群的高吞吐量。200ms之内可以重新选举出leader。

## Getting Started

1. 单机启动
2. 基本操作
3. 集群配置

## ZooKeeper Programmer's Guide

### The ZooKeeper Data Model

1. 节点命名规则。
2. 节点数据不要超过1M。
3. 节点类型：Ephemeral Nodes，Sequence Nodes，Container Nodes，TTL Nodes。
4. 节点的具体数据结构。

### ZooKeeper Sessions

1. zookeeper内部实现了自动重连集群的功能。

### ZooKeeper Watches

1. 特点：watch只触发一次。先通知watch事件，再改变数据。data watch和child watch之分。
2. 反复watch，需要不断的设置watch行为，这中间会丢失数据变更的通知。
3. 如果连接断开再恢复，会丢失数据变更的通知。

### Consistency Guarantees

1. 顺序一致、原子性、统一视图、可靠性、及时性。
2. client B如果想立即看到client A的修改，需要执行sync操作。






