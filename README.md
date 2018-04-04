# 工作日计算API

初始化工作

创建一个`workday`的数据库

把
```
src/main/resources/application.yml
```

里面的数据库地址，用户名，密码改成你自己的

```
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/workday
    username: root
    password: 你的密码
```

运行项目在

http://127.0.0.1/index

即可看到如下界面


![工作日图片](https://raw.githubusercontent.com/peer44/peer44.github.io/gh-pages/QQ%E6%88%AA%E5%9B%BE20180404130624.png)

## 节假日维护

通过上面的界面就可以维护节假日了

操作很简单，点击标记节假日，再次点击取消标记，这些数据都会保存到数据库

## 节假日计算

目前实现了两个方法

### 计算某天是不是工作日

### 某天之后/前多少天的工作日

![节假日api](https://raw.githubusercontent.com/peer44/peer44.github.io/gh-pages/swagger.png)

# 致谢

感谢这两位老铁，参照这两篇文章添加了农历

> http://feifei.im/archives/168

> https://blog.csdn.net/guogrower/article/details/79023423
