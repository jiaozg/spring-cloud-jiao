在微服务架构中，需要几个基础的服务治理组件，
包括服务注册与发现、服务消费、负载均衡、断路器、智能路由、配置管理等，
由这几个基础组件相互协作，共同组建了一个简单的微服务系统。

在Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过
负载均衡（zuul、Ngnix），
再到达服务网关（zuul集群），然后再到具体的服。，服务统一注册到高可用的服务注册中心集群，
服务的所有的配置文件由配置服务管理（下一篇文章讲述），
配置服务的配置文件放在git仓库，方便开发人员随时改配置。


一、Zuul简介

Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如／api/user转发到到user服务，
/api/shop转发到到shop服务。zuul默认和Ribbon结合实现了负载均衡的功能。

zuul有以下功能：

Authentication
Insights
Stress Testing
Canary Testing
Dynamic Routing
Service Migration
Load Shedding
Security
Static Response handling
Active/Active traffic management


http://localhost:8769/api-a/hi?name=forezp

http://localhost:8769/api-a/hi?name=forezp&token=1

zuul不仅只是路由，并且还能过滤，做一些安全验证。

filterType：返回一个字符串代表过滤器的类型，
在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
pre：路由之前
routing：路由之时
post： 路由之后
error：发送错误调用
filterOrder：过滤的顺序
shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
run：过滤器的具体逻辑。可用很复杂，
包括查sql，nosql去判断该请求到底有没有权限访问。