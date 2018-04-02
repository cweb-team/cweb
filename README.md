# cweb j2EE project

# 前端采用vue框架

# 学习资料

## SSM框架相关
1. [@responseBody注解的使用](https://www.cnblogs.com/qiankun-site/p/5774325.html)
2. [@RequestParam的作用](http://blog.csdn.net/u012726702/article/details/51813235)
3. [SSM框架下各个层的解释说明](http://blog.csdn.net/lutianfeiml/article/details/51864160)
4. [MyBatis传入参数与parameterType](http://blog.csdn.net/z69183787/article/details/50471607)
5. [以@Resource为例，透析注解的本质，spring中是如何使用注解的](http://blog.csdn.net/qq_27093465/article/details/52702463)
## 数据库相关
1. [java与mysql时间类型对应](http://blog.csdn.net/xinghuo0007/article/details/51500923)
2. [调用mybatis的insert（insertSelective）方法时获取新增数据的ID](https://blog.csdn.net/shuaipu813/article/details/52755808)
    1、在Mapper.xml文件中的对应方法中添加属性：useGeneratedKeys="true"和keyProperty="pkId"；
    其中useGeneratedKeys="true":设置是否使用JDBC的getGenereatedKeys方法获取主键并赋值到keyProperty设置的领域模型属性中;
    keyProperty：赋值的对象的属性名称，注意是model层的bean中的属性名而不是mysql数据表中的字段名。
    2、mysql数据表中对应ID字段要设置成自增。
    3、数据插入成功后对应的keyProperty属性就会变成新数据的ID。
# 项目修改注意事项
1. .xml文件和.java文件修改后，需要在maven里先执行clean再执行install，这之后再启动服务器才能完成修改
2. .properties和前端修代码修改后,直接重启服务器即可。


