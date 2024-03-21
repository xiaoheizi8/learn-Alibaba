# SpringCloud+Alibaba

#### 介绍
JDK17+SpringCloud+SpringCloudAlibaba

SpringBoot3+SpringCloud +SpringCloudAlibaba
拆为多模块demo工程
Consul，Localhost:8500
本地bat文件脚本配置:
@echo.服务启动......  
@echo off  
@sc create Consul binpath= "你的consul.exe路径 agent -server -ui -bind=127.0.0.1 -client=0.0.0.0 -bootstrap-expect  1  -data-dir 你选择离线存储的文件夹路径   "
@net start Consul
@sc config Consul start= AUTO  
@echo.Consul start is OK......success
@pause

 适配JDK 17切记

#### 特技

1.  使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2.  Gitee 官方博客 [blog.gitee.com](https://blog.gitee.com)
3.  你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解 Gitee 上的优秀开源项目
4.  [GVP](https://gitee.com/gvp) 全称是 Gitee 最有价值开源项目，是综合评定出的优秀开源项目
5.  Gitee 官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6.  Gitee 封面人物是一档用来展示 Gitee 会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)
