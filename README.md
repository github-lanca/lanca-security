# security

#### 介绍
spring_security

#### 说明
各种技术练习模块，非常随意

#### maven说明
pom.xml使用规范
```xml
 <dependencies>
    <!-- #1。内部模块依赖-->
    <dependency>
        <groupId>cn.lanca</groupId>
        <artifactId>common</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    
    <!-- #2。spring模块依赖-->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>
    
    <!-- #3。第三方模块依赖-->
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.5.1</version>
    </dependency>
</dependencies>
<!-- 模块化标识 主要是为了全部maven依赖统一在一个下面-->
<modules>
    <module>esaypoi</module>
    <module>springboot_mpp</module>
    <module>springboot_youzan</module>
    <module>springboot_test</module>
    <module>springboot_schedule</module>
    <module>common</module>
    <module>ip-spring-boot-start</module>
    <module>springboot-oauth2</module>
</modules>
```


