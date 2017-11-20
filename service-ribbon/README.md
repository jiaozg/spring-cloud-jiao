讲了服务的注册和发现。在微服务架构中，业务都会被拆分成一个独立的服务，服务与服务的通讯是基于http restful的。Spring cloud有两种服务调用方式，一种是ribbon+restTemplate，另一种是feign。在这一篇文章首先讲解下基于ribbon+rest。

一、ribbon简介

Ribbon is a client side load balancer which gives you a lot of control over the 
behaviour of HTTP and TCP clients. Feign already uses Ribbon, so if you are using 
@FeignClient then this section also applies.

—–摘自官网

http://localhost:8764/hi?name=forezp


http://localhost:8764/hystrix