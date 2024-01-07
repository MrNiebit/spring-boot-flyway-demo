# spring boot 接入flyway

```xml
<dependency>
  <groupId>org.flywaydb</groupId>
  <artifactId>flyway-core</artifactId>
  <version>7.15.0</version>
</dependency>
```
新版本不支持 MySQL 5.7

```properties
# ------ flyway ------
spring.flyway.locations=classpath:db/migration
spring.flyway.enabled=true
# 不自动创建history表，不会执行基线sql，
spring.flyway.baseline-on-migrate=false
##当flyway第一次运行时，会在我们对应的数据库中新建一个记录脚本运行情况的
spring.flyway.table=v_sql_version_history
```
示例脚本名：
```text
V2024.01.06.0__init_db.sql
V2024.01.06.1__init_db.sql
```
`V版本号__xxx.sql`
中间有两个 `_`

# 新的开发模式

传统：controller -> service -> dao
...