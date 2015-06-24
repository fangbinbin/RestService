# RestService
作为安卓端服务器接口服务使用

1.将github中的工程导入到eclipse中时，右键项目名称->run as->run on server,可能报一下错误：
java.lang.ClassNotFoundException: org.springframework.web.servlet.DispatcherServlet
解决方式：
You need to add the "Maven Dependency" in the Deployement Assembly
1)right click on your project and choose properties.
2)click on Deployement Assembly.
3)click add
4)click on "Java Build Path Entries"
5)select Maven Dependencies"
6)click Finish.
That it!! rebuild and deploy again