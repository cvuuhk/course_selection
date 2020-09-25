# 学生登录表

|       字段名       |    中文描述    |  数据类型   |             说明              |
| :----------------: | :------------: | :---------: | :---------------------------: |
|      username      |     用户名     |  char(10)   |     主键，由学号直接生成      |
|      password      |      密码      |  char(60)   | Bcrypt 加密后的密文，默认学号 |
|        role        |      角色      | varchar(20) |                               |
|       locked       | 账户是否被锁定 |   boolean   |                               |
|      enabled       |  账户是否启用  |   boolean   |                               |
|   accountExpired   |  账户是否过期  |   boolean   |                               |
| credentialsExpired |  密码是否过期  |   boolean   |                               |

