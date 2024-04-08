###1.目前学过的技术（建立分层的概念）

+ 表现层
  + 与浏览器打交道
  + 视图层：html，css，JavaScript，jsp，控制层，servlet，jsp
+ 业务逻辑层
  + 处理项目逻辑
  + 在正真的开发中，每个项目的业务不同，处理的逻辑页不同
  + service
+ 数据访问层
  + 操作数据库
  + 技术：jdbc，分层：dao

### 2.目前大家项目存在的问题

+ 项目和工程的关系
  + 目前我们开发的项目比较小，一个项目就是一个工程，但是在正真开发时，项目的体量会大很多，一个工程可能由多个项目构成
+ 问题：一个项目就是一个工程
  + 我们需要一个能把大项目拆分成多个工程的工具
+ 问题：项目依赖第三方的jar包，需要复制到项目中
  + 同样的jar包重复出现在不同的项目中，空间资源浪费
  + 我们需要一个集中管理jar包的工具
+ 问题：jar包来源
  + 官网下载
  + 知识付费
  + 我们需要自动下载jar包的工具
+ 问题：jar包不兼容，冲突，缺失，都会保错，
  + 需要一个规范jai包兼容性的问题

### 3.什么是maven

+ maven是一个基于java平台自动化构建和项目管理工具
+ 清理，编译，测试，打包，报告，部署
+ maven文件是通过

### 4.安装及配置maven

+ zip


+ 解压后配置环境变量即可使用
+ 没有中文，没有空格，没有特殊符号
+ 配置环境变量
+ 新建MAVEN_HOME环境变量
  + 值是Maven的解压路径（一直到bin目录的上一层）
  + 修改path，添加“%MAVEN_HOME%\bin”
  + cmd窗口mvn -v

### 5.创建本地仓库

+ 仓库：存放项目所需依赖（jar包）
  + 本地仓库：自己电脑上的某个文件夹
  + 私服：局域网内的仓库，公司开发的通用jar包，一般公司都有自己的私服
  + 中央仓库
  + 在Internert上，全世界的项目都可以用
  + 中央仓库的镜像
    + 分担中央仓库的压力，速度更快
+ Maven会将项目中依赖的jar包，从远程下载本机的一个目录（本地仓库）
+ 优先在本地仓库找
+ 配置本地仓库
+ 在任意盘下创建一个英文目录，rep


<url>http://123.232.10.234:8212/nexus/content/groups/public/</url>

        </mirror>
    	<!-- 阿里云仓库 -->
    	<mirror>
    		<id>alimaven</id>
    		<mirrorOf>central</mirrorOf>
    		<name>aliyun maven</name>
    		<url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
    	</mirror>
+ 中央仓库国外，速度比较满，这里用阿里云的镜像仓库，速度快

### 6.在ide中配置maven

+ 使用idea随便打开一个项目
+ file 》 setting》build》build tools》maven
+ 也可以直接搜maven
+ 设置自动下载依赖maven》import
+ ​

### 7.搭建maven的web项目

### 8.整合tomcat

### 9.完善src目录

+ 在main下创建Java文件夹，右键mark directory ===》sources root
  + 存放java文件
+ 在main下创建resources文件夹，右键mark directory ==>resources root
  + 存放配置文件
+ webapp目录下存放页面资源
  + 创建static文件夹，存放静态资源，css，JavaScript，images
  + 创建view文件夹，存放jsp页面

### 10.pom文件

+ ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!-- 项目的版本和编码格式-->
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <!-- 模板版本，与maven对应-->
    <modelVersion>4.0.0</modelVersion>
  <!-- 域名：公司或组织的唯一标识，打包依据，会形成路径com/jxd-->
    <groupId>com.jxd</groupId>
    <!-- 项目id，一个ground有很多artifact，靠id区分-->
    <artifactId>maven0204</artifactId>
    <!-- 版本号-->
    <version>1.0-SNAPSHOT</version>
    <!-- 打包方式，可以使用war包（放在tomcat下可以直接运行），也可以使用jar包-->
    <packaging>war</packaging>
  <!--名字地址-->
    <name>maven0204 Maven Webapp</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>
  <!-- 属性-->
    <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <!-- java版本，应该改成1.8，不改也行-->
      <maven.compiler.source>1.7</maven.compiler.source>
      <maven.compiler.target>1.7</maven.compiler.target>
    </properties>
  <!-- 依赖，代表项目需要引用的jar包<dependencies>，父标签，包含多标签-->
    <dependencies>
      <!-- 代表jar包，一个dependency代表一个jar包-->
      <dependency>
        <!-- 这三个元素，groupId，artifactId，version，是组成jar包的坐标，maven通过这个元素来获取jar包，凡是maven项目都有这三个属性，能被maven管理的jar包也有这三个属性-->
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
      </dependency>
    </dependencies>

    <build>
      <finalName>maven0204</finalName>
      <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
        <plugins>
          <plugin>
            <artifactId>maven-clean-plugin</artifactId>
            <version>3.1.0</version>
          </plugin>
          <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
          <plugin>
            <artifactId>maven-resources-plugin</artifactId>
            <version>3.0.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
          </plugin>
          <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.1</version>
          </plugin>
          <plugin>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-install-plugin</artifactId>
            <version>2.5.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.8.2</version>
          </plugin>
        </plugins>
      </pluginManagement>
    </build>
  </project>

  ```

+ 下载依赖的网站：https://mvnrepository.com/

+ 选择需要的jar包，将其dependency标签复制到pom文件中，粘贴后会自动下载，引入jar包

+ 如果删除标签，只是不再引用jar包，但是jar包仍然存在本地。