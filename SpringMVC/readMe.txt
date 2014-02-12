1)	数据传递到页面
	http://localhost:8080/SpringMVC/test1/helloworld

2)	一个controller中书写多个方法
	http://localhost:8080/SpringMVC/test1/multi?a=add
	http://localhost:8080/SpringMVC/test1/multi?a=update
	
3)	springMVC实现静态文件的访问:js,图片,css文件
	http://localhost:8080/SpringMVC/test1/img.do?a=img

4)	使用注解访问
	http://localhost:8080/SpringMVC/user/toUser
	更改jquery.jsp里form的action值，可以调用不同的controller方法
	
	spring 3.0开启注解的优化：<mvc:annotation-driven/>
	http://localhost:8080/SpringMVC/user2/toUser
	修改jquery.jsp里的action值，可以调用到User2Controller里的对应方法
	
5)	对象参数传递到页面
	http://localhost:8080/SpringMVC/user/data/toUser	json方式
	http://localhost:8080/SpringMVC/user/data/toUser2	传统方式

6)	文件上传
	http://localhost:8080/SpringMVC/file/toUpload
	upload.jsp里，action值是/SpringMVC/file/upload2时上传效率更高
	
7)	和Spring的集成
	无需新增jar包。
	http://localhost:8080/SpringMVC/spring/get
	
	测试springMVC和spring上下文关系
	
8)	和Hibernate集成
	完成CRUD操作
	http://localhost:8080/SpringMVC/userHibernate/toAddUser
	http://localhost:8080/SpringMVC/userHibernate/getAllUser

