介绍了服务注册与发现，其中服务注册中心Eureka Server，是一个实例，
当成千上万个服务向它注册的时候，它的负载是非常高的，这在生产环境上是不太合适的，
怎么将Eureka Server集群化。

需要改变etc/hosts，linux系统通过vim /etc/hosts ,加上：

127.0.0.1 peer1
127.0.0.1 peer2

windows电脑，在c:/windows/systems/drivers/etc/hosts 修改。

java -jar target/eureka-server-ha-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer1

java -jar target/eureka-server-ha-0.0.1-SNAPSHOT.jar --spring.profiles.active=peer2

eureka.instance.preferIpAddress=true是通过设置ip让eureka让其他服务注册它

Eureka-eserver peer1 8761,Eureka-eserver peer2 8769相互感应，当有服务注册时，
两个Eureka-eserver是对等的，它们都存有相同的信息，这就是通过服务器的冗余来增加可靠性，
当有一台服务器宕机了，服务并不会终止，因为另一台服务存有相同的数据。