# 用法
## 选举测试
1. 启动zookeeper服务端。
2. 启动2个"hello-zookeeper"客户端。
3. 执行spring shell指令：is-leader/start-election/stop-election，观察leader的变化情况。

## znode监听测试
1. 启动zookeeper服务端。
2. 启动1个"hello-zookeeper"客户端。
3. 启动zookeeper命令行客户端zkCli。
4. 在zkCli命令行执行create /hello-zookeeper/crud/name foo等指令测试，"hello-zookeeper"程序的控制台会输出数据变化。

# zookeeper文档

[官方文档](docs/reference.md)

# 选举逻辑

1. 参与选举的角色在指定的znode下创建临时的顺序节点。
2. 序号最小的节点成为leader。
3. 每一个节点watch上一个节点，上一个节点退出后，自己成为新的leader。

源码参考：

1. LockInternals.attemptLock() { driver.createsTheLock(client, path, localLockNodeBytes) }创建临时的顺序节点。
2. LockInternals.internalLockLoop() { driver.getsTheLock(client, children, sequenceNodeName, maxLeases) }序号最小的节点成为leader，这里maxLeases=1。
3. LockInternals.internalLockLoop() 轮询，让下一个序号最小的节点成为leader。