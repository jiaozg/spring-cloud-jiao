在分布式系统中，由于服务数量巨多，为了方便服务配置文件统一管理，实时更新，
所以需要分布式配置中心组件。在Spring Cloud中，有分布式配置中心组件spring cloud config ，
它支持配置服务放在配置服务的内存中（即本地），也支持放在远程Git仓库中。
在spring cloud config 组件中，分两个角色，一是config server，二是config client


spring.cloud.config.server.git.uri：配置git仓库地址
spring.cloud.config.server.git.searchPaths：配置仓库路径
spring.cloud.config.label：配置仓库的分支
spring.cloud.config.server.git.username：访问git仓库的用户名
spring.cloud.config.server.git.password：访问git仓库的用户密码

证明配置服务中心可以从远程程序获取配置信息。

http请求地址和资源文件映射如下:

/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties


http://localhost:8888/config-client/dev