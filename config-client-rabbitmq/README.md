依次启动eureka-server、confg-cserver,启动两个config-client，端口为：8881、8882。

访问http://localhost:8881/hi 或者http://localhost:8882/hi 浏览器显示：

这时我们去代码仓库将foo的值改为“foo version 4”，即改变配置文件foo的值。
如果是传统的做法，需要重启服务，才能达到配置文件的更新。
此时，我们只需要发送post请求：http://localhost:8881/bus/refresh，
你会发现config-client会重现读取配置文件