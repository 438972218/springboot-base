#基础版本包结构说明

## 介绍

### 背景
  - 鉴于每一个新系统都需要初始化的项目(Spring Boot)，并实现用户，角色，权限资源，登录，权限管理功能，及依赖引入过多与使用依赖的功能少之又少的大问题，因此本系统版本由此而生。

### 目的
  - 规定项目版本，及Spring Boot 版本号
  - 实现日后每个系统的基础功能
  - 实现用户，角色，权限资源功能，及登录功能

### 基本版本项目介绍
  - 基础框架：SpringBoot 2.4.5
  - ORM：Mybatis-plus 3.4.2
  - DB：MySQL 5.7.x
  - 权限管理：Shiro + Redis + JWT
 
 ### 项目结构简介
```text
├─main
│  ├─java
│  │  └─com
│  │      └─xdcplus                
│  │          └─xdcweb
│  │              ├─basics                                        基础功能包
│  │              │  ├─common                                     公共包
│  │              │  │  ├─annotation                              自定义注解包
│  │              │  │  ├─aspect                                  切面包
│  │              │  │  ├─config                                  基础功能配置包
│  │              │  │  ├─exception                               基础功能异常包
│  │              │  │  ├─pojo                                    基础功能POJO
│  │              │  │  │  ├─dto                                  基础功能DTO包
│  │              │  │  │  ├─entity                               DTO包
│  │              │  │  │  └─vo                                   VO包
│  │              │  │  ├─scheduling                              定时器包
│  │              │  │  └─validator                               参数校验包
│  │              │  │      └─groupvlidator
│  │              │  ├─controller                                 基础功能Controller包
│  │              │  ├─mapper                                     基础功能持久层包
│  │              │  └─service                                    基础功能业务层包
│  │              │      └─impl
│  │              │─global                                        全局包
│  │              │  ├─config                                     全局配置类包
│  │              │  ├─constants                                  全局常量类包
│  │              │  ├─enums                                      枚举类包
│  │              │  ├─exception                                  全局自定义异常
│  │              │  │   └─handler                                全局异常处理器
│  │              │  │─utils                                      全局工具类包
│  │              │  │─pojo                                       全局POJO包
│  │              │  │   │─dto                                    全局DTO对象
│  │              │  │   └─vo                                     全局VO对象
│  │              │  │─service                                    全局业务层（公共）接口
│  │              │  │   └─impl                                   
│  │              │  │─validator                                  参数校验包
│  │              │  │   └─groupvlidator
│  │              ├─.....                                         具体项目包名
│  └─resources
│      ├─mapper
│      ├─sql
│      └─templates
└─test
    └─java
        └─com
            └─xdcplus
                └─xdcweb
                    └─basics
                        ├─common
                        └─service
```
 
 ### 项目包结构命名规则
  - 参考基础功能包结构
 
## 工具类介绍

该版本使用Hutool 工具类包，因此关于工具类使用参考 

[中文文档](https://www.hutool.cn/docs/)
[中文文档（备用）](https://www.hutool.club/docs/)

[参考API](https://apidoc.gitee.com/loolly/hutool/)

## 注意

### 登录账号
   - 账号：admin
   - 密码：
    
### 认证模式
   - 目前基础版本已实现基础验证，摘要认证，均已加入验证码
    
#### 模式切换
   - 修改application.yml 中的 auth.mode的值即可
    
#### 摘要认证存在的问题
   - 由于摘要认证需要用到MD5加密而会产生前后端MD5加密不同，因此需要对中文特殊处理。
   - 中文的处理方式需要与前端约定因此在代码中未处理，若需要处理只需要修改” LoginInterceptor”拦截器中对账号的获取处理即可

##### 建议

#####js转换
``` javascript
encodeURIComponent("")
```

##### java 解密
``` java
URLDecoder.decode("", UTF_8)
```

### MyBatis主键策略

#### 策略
   在生成表主键ID时，我们可以考虑“主键自增”或者”UUID”，但他们都有很明显的缺点
 - UUID
        太长，并且有索引碎片，索引太占用空间的问题。
        无序
- 主键自增：
        自增ID容易被被爬虫遍历数据
        分表分库会有ID冲突
- 雪花算法：
        适合在分布式场景下生产唯一ID，
        既可以保证唯一又可以排序

##### 策略模式
  - 主键生成策略，支持分布式。目前支持UUID（UUID-String主键）、ASSIGN_ID(默认雪花算法)、INPUT(用户指定)。
  - 支持注解@TableId指定主键，
  - 注解优先级大于全局配置。
    
    
##### 策略配置
yml配置
```yml
mybatis-plus:
  global-config:
    db-config:
      # 主键ID 生成策略
      id-type: assign_id
```
        
##### 实体示例
```java
public class User {

    @TableId(IdType.ASSIGN_ID)
    private String id;

    private String userName;

    private String password;
}

```

### swagger配置
 - 由于swagger 扫描配置方式使用的是注解模式，因此需每个Controller 类上加入@RestController注解


### 鉴权注意事项
基础版本鉴权是基于JWT，该签名是有超时时间,  JWT签名是可配置，配置字段如下
```yaml
auth:
  accessTokenExpireTime: 10000
```
若签名失效会生成新的签名并返回，若不需要此操作可在ShiroRealm.java中文件将 "(jwtUtils.verify(token)" 这段代码删除即可

若需要该机制，需要WEB端监听鉴权TOKEN是否变更，新的鉴权TOKEN会在当次请求的Response Header 中

### Mybatis 逆向生成代码说明
 - 生成方法：com.xdcplus.xdcweb.global.generator.CodeGenerator.main
 - 生成包路径：generator
 
 需要自行将generator包下的生成代码拷贝至正式包中，然后将该包删除












