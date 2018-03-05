## 实测结果 ClassNotFoundException
```
java.lang.ClassNotFoundException: FileLoggerFactory
	at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
	at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:338)
	at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
	at java.lang.Class.forName0(Native Method)
	at java.lang.Class.forName(Class.java:264)
	at bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.one.FactoryMethodXMLUtil.getBean(FactoryMethodXMLUtil.java:36)
	at bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.one.FactoryMethodDemooptimizedOneClient.main(FactoryMethodDemooptimizedOneClient.java:19)
Exception in thread "main" java.lang.NullPointerException
	at bugmakers.club.dp.creational.seq2.factorymethod.demooptimized.one.FactoryMethodDemooptimizedOneClient.main(FactoryMethodDemooptimizedOneClient.java:20)
```

想想也是正常的，因为main去测试的时候，FileLoggerFactory这些具体工厂都是没有在容器里边的，所以自然会出现找不到类的情况