# 智慧关务平台 Smart Customs Platform

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen.svg" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Java-21-orange.svg" alt="Java"/>
  <img src="https://img.shields.io/badge/License-MIT-blue.svg" alt="License"/>
  <img src="https://img.shields.io/badge/Version-0.0.1--SNAPSHOT-yellow.svg" alt="Version"/>
</p>

<p align="center">
  <a href="#-项目简介">项目简介</a> •
  <a href="#%EF%B8%8F-技术栈">技术栈</a> •
  <a href="#-项目结构">项目结构</a> •
  <a href="#-快速开始">快速开始</a> •
  <a href="./CHANGELOG.md">更新日志</a> •
  <a href="./CONFIG_README.md">配置说明</a>
</p>

## 📖 项目简介

智慧关务平台是一个基于 Spring Boot 3.5.6 和 Java 21 构建的现代化企业级应用系统，专注于提供智能化的海关业务管理解决方案。项目底层重写自 RuoYi-Vue 和 RuoYi-Vue-Plus，支持多租户、分布式部署，提供完善的权限管理、数据加密、API接口加密等安全特性。

### ✨ 核心特性

- 🚀 **现代化技术栈**：基于 Spring Boot 3.5.6 + Java 21，支持虚拟线程
- 🔐 **完善的安全机制**：Sa-Token 认证授权、API加密、数据加密、XSS防护
- 🏢 **多租户架构**：支持 SaaS 模式的多租户数据隔离
- 📊 **动态数据源**：支持主从读写分离、多数据源动态切换
- 🎯 **分布式特性**：Redisson 分布式锁、分布式缓存、分布式任务调度
- 📝 **代码生成器**：支持快速生成 CRUD 代码，提高开发效率
- 📄 **接口文档**：集成 SpringDoc，自动生成 API 文档
- 📤 **文件存储**：支持本地、MinIO、阿里云 OSS、腾讯云 COS 等多种存储方式
- 📧 **消息通知**：支持邮件、短信等多种通知方式
- 🔄 **实时通信**：支持 SSE、WebSocket 实时推送

## 🛠️ 技术栈

### 后端框架

| 技术 | 版本 | 说明 |
|-----|------|------|
| Spring Boot | 3.5.6 | 核心框架 |
| MyBatis-Plus | 3.5.14 | ORM 框架 |
| Sa-Token | 1.44.0 | 权限认证框架 |
| Redisson | 3.51.0 | Redis 客户端 & 分布式工具 |
| Lock4j | 2.2.7 | 分布式锁 |
| Dynamic-Datasource | 4.3.1 | 动态数据源 |
| SnailJob | 1.8.0 | 分布式任务调度 |
| Hutool | 5.8.40 | Java 工具类库 |
| MapStruct Plus | 1.5.0 | 对象映射工具 |
| SpringDoc | 2.8.13 | API 文档生成 |
| FastExcel | 1.3.0 | Excel 处理 |
| SMS4J | 3.3.5 | 短信发送 |
| IP2Region | 2.7.0 | IP 地址定位 |
| P6Spy | 3.9.1 | SQL 性能分析 |

### 数据库

- MySQL 8.0+
- Redis 5.0+

### 开发工具

- JDK 21
- Maven 3.8+
- Git

## 📁 项目结构

```
smart-customs-platform-server
├── smart-customs-admin              # 管理后台模块
│   ├── src
│   │   ├── main
│   │   │   ├── java                # 启动类、配置类
│   │   │   └── resources           # 配置文件、静态资源
│   │   │       ├── application.yml
│   │   │       ├── application-dev.yml.template
│   │   │       ├── application-prod.yml.template
│   │   │       ├── banner.txt
│   │   │       └── logback-plus.xml
│   │   └── test
│   └── pom.xml
├── smart-customs-common             # 通用模块
│   ├── common-bom                  # 依赖管理
│   ├── common-core                 # 核心组件
│   ├── common-doc                  # 文档配置
│   ├── common-encrypt              # 加密模块
│   ├── common-excel                # Excel 处理
│   ├── common-idempotent           # 幂等性处理
│   ├── common-job                  # 任务调度
│   ├── common-json                 # JSON 处理
│   ├── common-log                  # 日志管理
│   ├── common-mail                 # 邮件发送
│   ├── common-mybatis              # MyBatis 增强
│   ├── common-oss                  # 对象存储
│   ├── common-ratelimiter          # 限流器
│   ├── common-redis                # Redis 工具
│   ├── common-satoken              # Sa-Token 集成
│   ├── common-security             # 安全配置
│   ├── common-sensitive            # 敏感词处理
│   ├── common-sms                  # 短信发送
│   ├── common-social               # 社交登录
│   ├── common-sse                  # SSE 推送
│   ├── common-tenant               # 多租户
│   ├── common-translation          # 国际化翻译
│   ├── common-web                  # Web 配置
│   └── common-websocket            # WebSocket
├── smart-customs-modules            # 业务模块
│   ├── business                    # 业务功能模块
│   ├── demo                        # 演示模块
│   ├── generator                   # 代码生成器
│   ├── job                         # 任务管理
│   └── system                      # 系统管理模块
├── smart-customs-extend             # 扩展模块
│   └── snailjob-server             # 分布式任务调度服务
├── .gitignore                      # Git 忽略配置
├── CHANGELOG.md                    # 更新日志
├── CONFIG_README.md                # 配置文件说明
├── LICENSE                         # MIT 开源协议
├── README.md                       # 项目说明文档
└── pom.xml                         # Maven 项目配置
```

## 🚀 快速开始

### 环境要求

- JDK 21+
- Maven 3.8+
- MySQL 8.0+
- Redis 5.0+

### 配置数据库

1. 创建数据库

```sql
CREATE DATABASE smart_customs_platform DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

2. 导入数据库脚本（如果有提供的话）

```bash
mysql -u root -p smart_customs_platform < db/schema.sql
```

### 配置应用

1. **复制配置模板文件**

详细的配置说明请参考 [CONFIG_README.md](./CONFIG_README.md)

```bash
# 主应用配置
cd smart-customs-admin/src/main/resources
cp application-dev.yml.template application-dev.yml

# SnailJob Server 配置（如需要）
cd smart-customs-extend/snailjob-server/src/main/resources
cp application-dev.yml.template application-dev.yml
```

2. **修改配置文件**

编辑 `application-dev.yml`，填写以下配置：

```yaml
# Redis 配置
spring:
  data:
    redis:
      host: localhost
      port: 6379
      password: your_password
      database: 0

# MySQL 配置
spring:
  datasource:
    dynamic:
      datasource:
        master:
          url: jdbc:mysql://localhost:3306/smart_customs_platform?useUnicode=true&characterEncoding=utf8&...
          username: root
          password: your_password
```

### 编译项目

```bash
# 安装依赖
mvn clean install

# 跳过测试编译
mvn clean install -DskipTests
```

### 启动应用

```bash
# 方式一：使用 Maven 启动
cd smart-customs-admin
mvn spring-boot:run

# 方式二：使用 JAR 包启动
java -jar smart-customs-admin/target/smart-customs-admin.jar

# 方式三：使用 IDE 启动
# 找到 smart-customs-admin 模块中的启动类运行
```

### 访问应用

- 应用地址：http://localhost:8080
- 接口文档：http://localhost:8080/doc.html
- 监控中心：http://localhost:8080/actuator

默认账号密码请查看数据库初始化脚本或联系管理员。

## 📚 开发指南

### 开发环境配置

1. **IDE 推荐**：IntelliJ IDEA 2024+
2. **插件推荐**：
   - Lombok
   - MyBatisX
   - Maven Helper

3. **代码风格**：
   - 遵循阿里巴巴 Java 开发规范
   - 使用 `.editorconfig` 统一代码格式

### 代码生成器使用

访问代码生成器模块，可快速生成 CRUD 代码：

```java
// 1. 配置数据库连接
// 2. 选择要生成的表
// 3. 配置生成路径和包名
// 4. 生成代码
```

### API 接口开发

1. 在 `smart-customs-modules` 中创建业务模块
2. 编写 Controller、Service、Mapper
3. 使用 `@ApiOperation` 注解生成接口文档
4. 访问 `/doc.html` 查看和测试接口

### 多租户开发

```java
// 在需要租户隔离的实体类上添加注解
@TableName(value = "sys_user", autoResultMap = true)
public class SysUser extends BaseEntity {
    // 租户ID字段会自动处理
}
```

## 🔐 安全配置

### 密码加密

系统使用 BCrypt 加密算法存储密码，密码强度要求：
- 长度至少 8 位
- 包含大小写字母、数字
- 密码错误次数超过 5 次将锁定账户 10 分钟

### API 接口加密

系统支持 API 接口加密，使用 RSA 非对称加密：

```java
@PostMapping("/encrypt")
@ApiEncrypt  // 开启接口加密
public R<String> encryptData() {
    return R.ok("sensitive data");
}
```

### 数据脱敏

支持敏感字段自动脱敏：

```java
@TableField(typeHandler = EncryptTypeHandler.class)
private String idCard;  // 身份证号自动脱敏
```

## 📦 部署说明

### JAR 包部署

```bash
# 1. 打包
mvn clean package -P prod

# 2. 上传 JAR 包到服务器

# 3. 配置生产环境配置文件
cp application-prod.yml.template application-prod.yml
vim application-prod.yml

# 4. 启动应用
nohup java -jar -Xms512m -Xmx1024m smart-customs-admin.jar --spring.profiles.active=prod > app.log 2>&1 &
```

### Docker 部署

```bash
# 1. 构建镜像
docker build -t smart-customs-platform:0.0.1 .

# 2. 运行容器
docker run -d -p 8080:8080 \
  -e SPRING_PROFILES_ACTIVE=prod \
  -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/smart_customs_platform \
  -e SPRING_REDIS_HOST=redis \
  --name smart-customs \
  smart-customs-platform:0.0.1
```

### Nginx 反向代理配置

```nginx
server {
    listen 80;
    server_name your-domain.com;

    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
    }
}
```

## 📊 监控和日志

### 应用监控

访问 Spring Boot Admin 监控中心：
- 地址：http://localhost:8080/actuator
- 账号密码：配置文件中 monitor.username 和 monitor.password

### 日志管理

日志文件位置：`./logs/`
- sys-console.log：控制台日志
- sys-error.log：错误日志
- sys-info.log：业务日志

日志配置文件：`logback-plus.xml`

## 🤝 贡献指南

欢迎提交 Issue 和 Pull Request！

### 提交规范

Commit Message 格式：

```
<type>(<scope>): <subject>

<body>

<footer>
```

type 类型：
- ✨ feat：新功能
- 🐛 fix：修复bug
- 📝 docs：文档更新
- 💄 style：代码格式调整
- ♻️ refactor：重构
- ⚡ perf：性能优化
- ✅ test：测试相关
- 🔧 chore：构建/工具链相关

示例：
```
✨ feat(system): 添加用户导出功能

增加用户数据批量导出为Excel功能
支持自定义导出字段和排序

Closes #123
```

## 📋 更新日志

查看 [CHANGELOG.md](./CHANGELOG.md) 了解项目的所有版本变更记录。

**最新版本**：v0.0.1-SNAPSHOT (2025-10-06)

主要更新：
- ✨ 完整的 RBAC 权限管理系统
- 🏢 多租户架构支持
- 🔐 完善的安全机制（API加密、数据加密、XSS防护）
- 📊 动态数据源、分布式锁、任务调度
- 📝 代码生成器、接口文档自动生成

## 📄 许可证

本项目采用 [MIT](LICENSE) 许可证。

## 👨‍💻 作者

**ZHANGCHAO**

- Email: vuanne1@gmail.com
- GitHub: https://github.com/yak33/smart-customs-platform-server

## 🙏 鸣谢

感谢以下开源项目：

- [RuoYi-Vue-Plus](https://gitee.com/dromara/RuoYi-Vue-Plus)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [MyBatis-Plus](https://baomidou.com/)
- [Sa-Token](https://sa-token.cc/)
- [Hutool](https://hutool.cn/)

## 📞 联系我们

如有问题或建议，欢迎通过以下方式联系：

- 提交 [Issue](https://github.com/yak33/smart-customs-platform-server/issues)
- 发送邮件至：vuanne1@gmail.com

---

⭐ 如果这个项目对你有帮助，请给一个 Star 支持一下！

---

**Made with ❤️ by ZHANGCHAO**