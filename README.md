# EngageCloud
云原生大作业，开发一个 Spring Boot 应用，并使用云原生功能

## 功能要求
1. 实现一个 REST 接口（简单接口即可，比如 json 串 {"msg":"hello"}）
2. 接口提供限流功能，当请求达到每秒 100 次的时候，返回 429（Too many requests）
3. 加分项：当后端服务有多个实例的时候（一个 Service 包含若干个 Pod），如何实现统一限流

## DevOps 要求
1. 为该项目准备 Dockerfile，用于构建镜像
2. 为该项目准备 Kubernetes 编排文件，用于在 Kubernetes 集群上创建 Deployment 和 Service
3. 编写 Jenkins 持续集成流水线，实现代码构建/单元测试/镜像构建功能（需要写至少一个单元测试）
4. 编写 Jenkins 持续部署流水线，实现部署到 Kubernetes 集群的功能，该流水线的触发条件为持续集成流水线执行成功
5. 注意：持续集成流水线和持续部署流水线也可以合二为一。
   
## 扩容场景
1. 为该 Java 项目提供 Prometheus metrics 接口，可以供 Prometheus 采集监控指标
2. 在 Grafana 中的定制应用的监控大屏（CPU/内存/JVM）
3. 使用压测工具（例如 Jmeter）对接口进压测，在 Grafana 中观察监控数据
4. 通过 Kubernetes 命令进行手工扩容，并再次观察 Grafana 中的监控数据
5. 加分项：使用 Kubernetes HPA 模块根据 CPU 负载做服务的 Auto Scale
