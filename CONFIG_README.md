# 配置文件使用说明

## 📋 概述

为了保护敏感信息（如数据库密码、API密钥等），本项目的环境配置文件已被加入 `.gitignore`，不会提交到 Git 仓库。

## 🔧 首次配置步骤

### 1. 主应用配置

复制模板文件并重命名：
```bash
cd smart-customs-admin/src/main/resources
cp application-dev.yml.template application-dev.yml
```

### 2. 填写配置信息

打开 `application-dev.yml` 文件，将所有 `YOUR_XXX` 占位符替换为实际的配置值：

#### 必填配置项

| 配置项 | 说明 | 示例值 |
|-------|------|--------|
| `YOUR_REDIS_HOST` | Redis服务器地址 | `localhost` 或 `192.168.1.100` |
| `YOUR_REDIS_PORT` | Redis端口 | `6379` |
| `YOUR_REDIS_DATABASE` | Redis数据库索引 | `0` |
| `YOUR_REDIS_PASSWORD` | Redis密码（无密码则留空） | `your_password` 或 留空 |
| `YOUR_DB_HOST` | MySQL数据库地址 | `localhost` 或 `192.168.1.100` |
| `YOUR_DB_PORT` | MySQL端口 | `3306` |
| `YOUR_DB_NAME` | 数据库名称 | `smart-customs-platform` |
| `YOUR_DB_USERNAME` | 数据库用户名 | `root` |
| `YOUR_DB_PASSWORD` | 数据库密码 | `your_db_password` |

#### 可选配置项

如果需要使用邮件发送、短信发送等功能，请取消对应配置的注释并填写相关信息。

## 🔐 安全注意事项

1. **切勿提交** `application-dev.yml`、`application-test.yml`、`application-prod.yml` 等包含敏感信息的文件到 Git
2. 这些文件已在 `.gitignore` 中配置，Git 会自动忽略它们
3. 如果不慎提交了敏感信息，请立即执行以下命令从 Git 历史中移除：

```bash
# 从 Git 缓存中移除文件（保留本地文件）
git rm --cached smart-customs-admin/src/main/resources/application-dev.yml

# 提交更改
git commit -m "🔒 移除敏感配置文件"

# 推送到远程仓库
git push origin main
```

## 📝 团队协作说明

- 每位开发人员需要自行创建 `application-dev.yml` 文件
- 参考 `application-dev.yml.template` 模板文件填写配置
- 不同开发人员可以使用不同的本地配置（如不同的数据库实例）
- 模板文件的更新会被提交到 Git，所有人可以获取最新的配置结构

## 🚀 启动项目

确保完成配置后，运行以下命令启动项目：

```bash
# 启动主应用
cd smart-customs-admin
mvn spring-boot:run
```

## ❓ 常见问题

### Q: 忘记填写某个配置项会怎样？
A: 项目启动时会报错，根据错误信息补充对应的配置即可。

### Q: 如何切换到生产环境配置？
A: 同样复制 `application-prod.yml.template`（如有）为 `application-prod.yml` 并填写生产环境的配置信息。

### Q: 配置文件已经提交到 Git 了怎么办？
A: 参考上面的"安全注意事项"部分，使用 `git rm --cached` 命令移除。

---

**作者**: ZHANGCHAO  
**项目**: smart-customs-platform-server
