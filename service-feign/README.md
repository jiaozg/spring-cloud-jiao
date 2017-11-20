在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），
在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。为了保证其高可用，
单个服务通常会集群部署。由于网络原因或者自身的原因，服务并不能保证100%可用，如果单个服务出现问题，
调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，
导致服务瘫痪。服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，
这就是服务故障的“雪崩”效应。

为了解决这个问题，业界提出了断路器模型。

一、断路器简介

Netflix has created a library called Hystrix that implements the 
circuit breaker pattern. In a microservice architecture 
it is common to have multiple layers of service calls.

. —-摘自官网


http://localhost:8765/hi?name=forezp