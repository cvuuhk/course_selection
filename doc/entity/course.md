# 课程表

|  字段名   |  中文描述  |     数据类型     |          说明          |
| :-------: | :--------: | :--------------: | :--------------------: |
|    id     |   课程号   |     char(10)     | 主键，唯一指定一门课程 |
|   name    |   课程名   |   varchar(100)   |         课程名         |
| remaining | 课程剩余量 | tinyint unsigned |  低于剩余量则无法选课  |

