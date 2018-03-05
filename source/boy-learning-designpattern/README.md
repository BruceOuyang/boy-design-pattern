## 源码结构具体说明

设计模式分为三种类型：
* 创建型模式 Creation Pattern
* 结构型模式 Structural Pattern
* 行为型模式 Behavioral Pattern

源码的结构也按照这三种类型来组成，即每一个设计模式对应一个包(package)，每一个设计模式的包下边有个四个文件夹：
* structural 该设计模式结构
* demo 示例
* demooptimized 示例优化
* practice 练习

例如：
```
├─creational
│  ├─seq1
│  │  └─simplefactory
│  │      ├─demo
│  │      ├─demooptimized
│  │      ├─practice
│  │      └─structural
```

在test目录下也有对应的4个文件夹，里边放置的是对应的应用测试代码