# Singleton

## Basic Singleton
Work ! Singleton will be instanciated during the starting of the application.

## Lazy Basic Singleton
Does not work on multi-threads environment (as a server).

## Synchronized Singleton 
Work ! Be carefull synchronize in method is very expensive, you might have slow performance.  

## Local Synchronized Singleton
Does not work! Because compilator inline the code for more precision read the following documentation (http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html)

##Holder Singleton
Work ! This is the best implementation singleton.

## Serializable Singleton 
If you want to serializable your singleton you should implement Object readResolve()

## Multi Classloader environment !!!
A singleton is a singleton by classloader, be carefull in multi-classloader environment as jee server.
You should use ClassLoader.getSystemClassLoader()  cf :http://surguy.net/articles/communication-across-classloaders.xml
_____________________
##### Documentations
http://thecodersbreakfast.net/index.php?post/2008/02/25/26-de-la-bonne-implementation-du-singleton-en-java
https://www.geeksforgeeks.org/prevent-singleton-pattern-reflection-serialization-cloning/