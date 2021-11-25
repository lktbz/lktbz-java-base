# 		javassist 学习笔记

### 目的

阅读dubbo 源码发现用到了spi  ，跟进去发现自己拼java 代码，很是好奇，既然是高级了，肯定要学这块了

### Demo

```java
/**
	参考类在下面
*/
public class JavassistLearn {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //创建类池
        ClassPool aDefault = ClassPool.getDefault();
        //创建类
        CtClass ctClass = aDefault.makeClass("com.xiao.java8.lktbz");
        StringBuffer sb=null;
        //参数1属性类型，2属性名称 3所属类
        CtField ctField=new CtField(aDefault.get("java.lang.String"),"name",ctClass);
        //设置修饰
        ctField.setModifiers(Modifier.PRIVATE);
        //设置getset
        ctClass.addMethod(CtNewMethod.setter("setName",ctField));
        ctClass.addMethod(CtNewMethod.getter("getName",ctField));
        //设置name 的默认值
        ctClass.addField(ctField, CtField.Initializer.constant("default"));

        //构造函数
        CtConstructor constructor =new CtConstructor(new CtClass[]{},ctClass);
        sb=new StringBuffer();
        sb.append("{\n name=\"me\";\n}");
        constructor.setBody(sb.toString());
        ctClass.addConstructor(constructor);

        //创建方法
        CtMethod ctMethod=new CtMethod(CtClass.voidType,"execute",new CtClass[]{},ctClass);
        ctMethod.setModifiers(Modifier.PUBLIC);
        sb=new StringBuffer();
        sb.append("{\n System.out.println(name); ");
        sb.append("\n System.out.println(\"execute ok\");");
        sb.append("\n return ;");
        sb.append("\n}");
        ctMethod.setBody(sb.toString());
        ctClass.addMethod(ctMethod);
        Class<?> aClass = ctClass.toClass();
        Object o = aClass.newInstance();
        Method execute = o.getClass().getMethod("execute", new Class[]{});
        //调用字节码生成类的execute方法
        execute.invoke(o,new Object[]{});
    }
}
```

##### 参考类

```java
public class JavassistClass {
    private String name="default";
    public JavassistClass(){
        name="me";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void execute(){
        System.out.println(name);
        System.out.println("execute ok");
    }
}
```

### 组件介绍

> **往中间件开发，以及框架开发必备技术**

#### 一：**读取和输出字节码**

```java
//加载类
ClassPool pool = ClassPool.getDefault();
//会从classpath中查询该类
CtClass cc = pool.get("test.Rectangle");
//设置.Rectangle的父类
cc.setSuperclass(pool.get("test.Point"));
//输出.Rectangle.class文件到该目录中
cc.writeFile("c://");
//输出成二进制格式
//byte[] b=cc.toBytecode();
//输出并加载class 类，默认加载到当前线程的ClassLoader中，也可以选择输出的ClassLoader。
//Class clazz=cc.toClass();
```

> 输出方式有三种

#### 二：**新增Class**

```java
ClassPool pool = ClassPool.getDefault();
//创建类名，可以将包名一起输入
CtClass cc = pool.makeClass("Point");
//新增方法
cc.addMethod(m);
//新增Field
cc.addField(f);
```

#### 三：**冻结Class**

```java
/**
当CtClass 调用writeFile()、toClass()、toBytecode() 这些方法的时候，Javassist会冻结CtClass Object，对CtClass object的修改将不允许。这个主要是为了警告开发者该类已经被加载，而JVM是不允许重新加载该类的。如果要突破该限制，方法如下：
**/
CtClasss cc = ...;
    
cc.writeFile();
cc.defrost();
cc.setSuperclass(...);     // OK since the class is not frozen.
//当 ClassPool.doPruning=true的时候，Javassist 在CtClass object被冻结时，会释放存储在//ClassPool对应的数据。这样做可以减少javassist的内存消耗。默认情况ClassPool.doPruning=false。例如

CtClasss cc = ...;
cc.stopPruning(true);
    :
cc.writeFile();                             // convert to a class file.
// cc没有被释放

//提示：当调试时，可以调用debugWriteFile()，该方法不会导致CtClass被释放。

```

#### 四：**Class 搜索路径**

> 从上面可以看出Class 的载入是依靠ClassPool，而ClassPool.getDefault() 方法的搜索Classpath 只是搜索JVM的同路径下的class。当一个程序运行在JBoss或者Tomcat下，ClassPool Object 可能找到用户的classes。Javassist 提供了四种动态加载classpath的方法。如下

```java
//默认加载方式如pool.insertClassPath(new ClassClassPath(this.getClass()));
ClassPool pool = ClassPool.getDefault();

//1:从file加载classpath
pool.insertClassPath("/usr/local/javalib")
 
//2:从URL中加载
ClassPath cp = new URLClassPath("www.javassist.org", 80, "/java/", "org.javassist.");
pool.insertClassPath(cp);

//3:从byte[] 中加载
byte[] b = a byte array;
String name = class name;
cp.insertClassPath(new ByteArrayClassPath(name, b));

//4:可以从输入流中加载class
InputStream ins = an input stream for reading a class file;
CtClass cc = cp.makeClass(ins);

```

#### 五：**ClassPool**四

###### 5.1**减少内存溢出**

>   ClassPool是一个CtClass objects的装载容器。当加载了CtClass object后，是不会被ClassPool释放的（默认情况下）。这个是因为CtClass object 有可能在下个阶段会被用到。
>
> ​     当加载过多的CtClass object的时候，会造成OutOfMemory的异常。为了避免这个异常，javassist提供几种方法，一种是在上面提到的 ClassPool.doPruning这个参数，还有一种方法是调用CtClass.detach()方法，可以把CtClass object 从ClassPool中移除。例如：

```java
CtClass cc = ... ;
cc.writeFile();
cc.detach();
```

> 另外一中方法是不用默认的ClassPool即不用 ClassPool.getDefault()这个方式来生成。这样当ClassPool 没被引用的时候，JVM的垃圾收集会收集该类。例如

```java
//ClassPool(true) 会默认加载Jvm的ClassPath
ClassPool cp = new ClassPool(true);
// if needed, append an extra search path by appendClassPath()
```

###### **5.2  级联ClassPools**

>  javassist支持级联的ClassPool，即类似于继承。例如：

```java
ClassPool parent = ClassPool.getDefault();
ClassPool child = new ClassPool(parent);
child.insertClassPath("./classes");
```

###### **5.3 修改已有Class的name以创建一个新的Class**

> 当调用setName方法时，会直接修改已有的Class的类名，如果再次使用旧的类名，则会重新在classpath路径下加载。例如：

```java
ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.get("Point");
cc.setName("Pair");
//重新在classpath加载
CtClass cc1 = pool.get("Point");
```

>
>
>对于一个被冻结（Frozen)的CtClass object ，是不可以修改class name的，如果需要修改，则可以重新加载，例如：

```java
ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.get("Point");
cc.writeFile();
//cc.setName("Pair");    wrong since writeFile() has been called.
CtClass cc2 = pool.getAndRename("Point", "Pair");
```

#### 六：**Class loader**

>  上面也提到，javassist同个Class是不能在同个ClassLoader中加载两次的。所以在输出CtClass的时候需要注意下，例如：

```java
// 当Hello未加载的时候，下面是可以运行的。
ClassPool cp = ClassPool.getDefault();
CtClass cc = cp.get("Hello");
Class c = cc.toClass();
//下面这种情况，由于Hello2已加载，所以会出错
Hello2 h=new Hello2();
CtClass cc2 = cp.get("Hello2");
Class c2 = cc.toClass();//这里会抛出java.lang.LinkageError 异常
//解决加载问题，可以指定一个未加载的ClassLoader
Class c3 = cc.toClass(new MyClassLoader());
```

###### **6.1 使用javassist.Loader**

```java
//从上面可以看到，如果在同一个ClassLoader加载两次Class抛出异常，为了方便javassist也提供一个Classloader供使用，例如
 ClassPool pool = ClassPool.getDefault();
 Loader cl = new Loader(pool);
 CtClass ct = pool.get("test.Rectangle");
ct.setSuperclass(pool.get("test.Point"));
Class c = cl.loadClass("test.Rectangle");
Object rect = c.newInstance();
```

> 为了方便监听Javassist自带的ClassLoader的生命周期，javassist也提供了一个listener，可以监听ClassLoader的生命周期，例如：

```java
//Translator 为监听器
public class MyTranslator implements Translator {
    void start(ClassPool pool)
        throws NotFoundException, CannotCompileException {}
    void onLoad(ClassPool pool, String classname)
        throws NotFoundException, CannotCompileException
    {
        CtClass cc = pool.get(classname);
        cc.setModifiers(Modifier.PUBLIC);
    }
}
//示例
public class Main2 {
  public static void main(String[] args) throws Throwable {
     Translator t = new MyTranslator();
     ClassPool pool = ClassPool.getDefault();
     Loader cl = new Loader();
     cl.addTranslator(pool, t);
     cl.run("MyApp", args);
  }
}
```

###### **6.2 修改系统Class**

>由JVM规范可知，system classloader 是比其他classloader 是优先加载的，而system classloader 主要是加载系统Class，所以要修改系统Class，如果默认参数运行程序是不可能修改的。如果需要修改也有一些办法，即在运行时加入-Xbootclasspath/p: 参数的意义可以参考其他文件。下面修改String的例子如下：

```java
ClassPool pool = ClassPool.getDefault();
CtClass cc = pool.get("java.lang.String");
CtField f = new CtField(CtClass.intType, "hiddenValue", cc);
f.setModifiers(Modifier.PUBLIC);
cc.addField(f);
cc.writeFile(".");
```

###### **6.3 动态重载Class**

```java
//如果JVM运行时开启JPDA（Java Platform Debugger Architecture），则Class是运行被动态重新载入的。具体方式可以参考java.lang.Instrument。javassist也提供了一个运行期重载Class的方法，具体可以看API 中的javassist.tools.HotSwapper。

```

#### 七：**Introspection和定制**

> javassist封装了很多很方便的方法以供使用，大部分使用只需要用这些API即可，如果不能满足，Javassist也提供了一个低层的API（具体参考javassist.bytecode 包）来修改原始的Class。

###### **7.1 插入source 文本在方法体前或者后**

`CtMethod 和CtConstructor 提供了 insertBefore()、insertAfter()和 addCatch()方法，它们可以插入一个souce文本到存在的方法的相应的位置。javassist 包含了一个简单的编译器解析这souce文本成二进制插入到相应的方法体里。`

​     javassist 还支持插入一个代码段到指定的行数，前提是该行数需要在class 文件里含有。

​     `插入的source 可以关联fields 和methods，也可以关联方法的参数。但是关联方法参数的时，需要在程序编译时加上 -g 选项（该选项可以把本地变量的声明保存在class 文件中，默认是不加这个参数的。）。因为默认一般不加这个参数，所以Javassist也提供了一些特殊的变量来代表方法参数：$1,$2,$args...要注意的是，插入的source文本中不能引用方法本地变量的声明，但是可以允许声明一个新的方法本地变量，除非在程序编译时加入-g选项。`

方法的特殊变量说明：



| $0, $1, $2, ... | this and actual parameters                                   |
| --------------- | ------------------------------------------------------------ |
| $args           | An array of parameters. The type of $args is Object[].       |
| $$              | All actual parameters.For example, m($$) is equivalent to m($1,$2,...) |
| $cflow(...)     | cflow variable                                               |
| $r              | The result type. It is used in a cast expression.            |
| $w              | The wrapper type. It is used in a cast expression.           |
| $_              | The resulting value                                          |
| $sig            | An array of java.lang.Class objects representing the formal parameter types |
| $type           | A java.lang.Class object representing the formal result type. |
| $class          | A java.lang.Class object representing the class currently edited. |



###### **7.1.1 $0, $1, $2, ...**

`$0代码的是this，$1代表方法参数的第一个参数、$2代表方法参数的第二个参数,以此类推，$N代表是方法参数的第N个。例如：`

```java
//实际方法

void move(int dx, int dy) 

//javassist

CtMethod m = cc.getDeclaredMethod("move");

//打印dx，和dy

m.insertBefore("{ System.out.println($1); System.out.println($2); }");

注意：如果javassist改变了$1的值，那实际参数值也会改变。
```



###### **7.1.2 $args**

`$args 指的是方法所有参数的数组，类似Object[]，如果参数中含有基本类型，则会转成其包装类型。需要注意的时候，$args[0]对应的是$1,而不是$0，$0!=$args[0]，$0=this。`



###### **7.1.3 $$**

`$$是所有方法参数的简写，主要用在方法调用上。例如：`

```java
//原方法

move(String a,String b)

move($$) 相当于move($1,$2)

//如果新增一个方法，方法含有move的所有参数，则可以这些写：

exMove($$, context) 相当于 exMove($1, $2, context)


```

###### **7.1.4 $cflow**

` $cflow意思为控制流（control flow），是一个只读的变量，值为一个方法调用的深度。例如：`

```java
int fact(int n) {
    if (n <= 1)
        return n;
    else
       return n * fact(n - 1);
}

//javassist调用

CtMethod cm = ...;

//这里代表使用了cflow

cm.useCflow("fact");

//这里用了cflow，说明当深度为0的时候，就是开始当第一次调用fact的方法的时候，打印方法的第一个参数

cm.insertBefore("if ($cflow(fact) == 0)"
           \+ "    System.out.println(\"fact \" + $1);");


```



###### **7.1.5 $r**

`指的是方法返回值的类型，主要用在类型的转型上。例如：`

```java
Object result = ... ;

$_ = ($r)result;

//如果返回值为基本类型的包装类型，则该值会自动转成基本类型，如返回值为Integer，则$r为int。如果返回值为void，则该值为null。
```

###### **7.1.6 $w**

`$w代表一个包装类型。主要用在转型上。比如：Integer i = ($w)5; 如果该类型不是基本类型，则会忽略。`



###### **7.1.7 $_**

`$_代表的是方法的返回值。`



###### **7.1.8 $sig**

`$sig指的是方法参数的类型（Class）数组，数组的顺序为参数的顺序。`



###### **7.1.9 $class**

`$class 指的是this的类型（Class）。也就是$0的类型。`



###### **7.1.10 addCatch()**

`addCatch() 指的是在方法中加入try catch 块，需要主要的是，必须在插入的代码中，加入return 值。$e代表 异常值。比如：`

```java
CtMethod m = ...;
CtClass etype = ClassPool.getDefault().get("java.io.IOException");
m.addCatch("{ System.out.println($e); throw $e; }", etype);
//实际代码如下：
try {
   the original method body
}
catch (java.io.IOException e) {
   System.out.println(e);
   throw e;

}
```



#### **八：修改方法体**

` CtMethod 和CtConstructor 提供了 setBody() 的方法，可以替换方法或者构造函数里的所有内容。`

`支持的变量`

| $0, $1, $2, ... | this and actual parameters                                   |
| --------------- | ------------------------------------------------------------ |
| $args           | An array of parameters. The type of $args is Object[].       |
| $$              | All actual parameters.For example, m($$) is equivalent to m($1,$2,...) |
| $cflow(...)     | cflow variable                                               |
| $r              | The result type. It is used in a cast expression.            |
| $w              | The wrapper type. It is used in a cast expression.           |
| $sig            | An array of java.lang.Class objects representing the formal parameter types |
| $type           | A java.lang.Class object representing the formal result type. |
| $class          | A java.lang.Class object representing the class currently edited. |



`注意 $_变量不支持。`



###### **8.1 替换方法中存在的source**

`javassist 允许修改方法里的其中一个表达式。 javassist.expr.ExprEditor 这个class 可以替换该表达式。例如：`

```java
CtMethod cm = ... ;

cm.instrument(

​    new ExprEditor() {

​        public void edit(MethodCall m)

​                      throws CannotCompileException

​        {

​            if (m.getClassName().equals("Point")

​                          && m.getMethodName().equals("move"))

​                m.replace("{ $1 = 0; $_ = $proceed($$); }");

​        }

​    });

//注意： that the substituted code is not an expression but a statement or a block. It cannot be or contain a try-catch statement.
  //  方法instrument() 可以用来搜索方法体里的内容。比如调用一个方法，field访问，对象创建等。如果你想在某个表达式前后插入方法，则修改的souce如下：

{ before-statements;

  $_ = $proceed($$);

  after-statements; }


```









###### **8.2 javassist.expr.MethodCall**

`MethodCall代表的是一个方法的调用。用replace()方法可以对调用的方法进行替换。`



| $0          | The target object of the method call. This is not equivalent to this, which represents the caller-side this object. $0 is null if the method is static. |
| ----------- | ------------------------------------------------------------ |
| $1, $2, ... | The parameters of the method call.                           |
| $_          | The resulting value of the method call.                      |
| $r          | The result type of the method call.                          |
| $class      | A java.lang.Class object representing the class declaring the method. |
| $sig        | An array of java.lang.Class objects representing the formal parameter types |
| $type       | A java.lang.Class object representing the formal result type. |
| $proceed    | The name of the method originally called in the expression.  |



`注意：$w, $args 和 $$也是允许的。$0不是this，是只调用方法的Object。$proceed指的是一个特殊的语法，而不是一个String。`



###### **8.3 javassist.expr.ConstructorCall**

`ConstructorCall 指的是一个构造函数，比如：this()、super()的调用。ConstructorCall.replace()是用来用替换一个块当调用构造方法的时候。`

| $0          | The target object of the constructor call. This is equivalent to this. |
| ----------- | ------------------------------------------------------------ |
| $1, $2, ... | The parameters of the constructor call.                      |
| $class      | A java.lang.Class object representing the class declaring the constructor. |
| $sig        | An array of java.lang.Class objects representing the formal parameter types. |
| $proceed    | The name of the constructor originally called in the expression. |



`$w, $args 和 $$  也是允许的。`



###### **8.4 javassist.expr.FieldAccess**

`FieldAccess代表的是Field的访问类。`

| $0       | The object containing the field accessed by the expression. This is not equivalent to this. this represents the object that the method including the expression is invoked on. $0 is null if the field is static. |
| -------- | ------------------------------------------------------------ |
| $1       | The value that would be stored in the field if the expression is write access. Otherwise, $1 is not available. |
| $_       | The resulting value of the field access if the expression is read access. Otherwise, the value stored in $_ is discarded. |
| $r       | The type of the field if the expression is read access. Otherwise, $r is void. |
| $class   | A java.lang.Class object representing the class declaring the field. |
| $type    | A java.lang.Class object representing the field type.        |
| $proceed | The name of a virtual method executing the original field access. . |



`$w, $args 和 $$  也是允许的。`



###### **8.5 javassist.expr.NewExpr**

`NewExpr代表的是一个Object 的操作(但不包括数组的创建)。`

| $0          | null                                                         |
| ----------- | ------------------------------------------------------------ |
| $1, $2, ... | The parameters to the constructor.                           |
| $_          | The resulting value of the object creation. A newly created object must be stored in this variable. |
| $r          | The type of the created object.                              |
| $sig        | An array of java.lang.Class objects representing the formal parameter types |
| $type       | A java.lang.Class object representing the class of the created object. |
| $proceed    | The name of a virtual method executing the original object creation. . |



`$w, $args 和 $$  也是允许的。`



###### **8.6 javassist.expr.NewArray**

`NewArray 代表的是数组的创建。`

| $0          | null                                                         |
| ----------- | ------------------------------------------------------------ |
| $1, $2, ... | The size of each dimension.                                  |
| $_          | The resulting value of the object creation.  A newly created array must be stored in this variable. |
| $r          | The type of the created object.                              |
| $type       | A java.lang.Class object representing the class of the created array . |
| $proceed    | The name of a virtual method executing the original array creation. . |



`$w, $args 和 $$  也是允许的。`

>  例如：
>
> String[][] s = new String[3][4];
>
>  $1 和 $2 的值为 3 和 4, $3 得不到的.
>
> String[][] s = new String[3][];
>
>  $1 的值是 3 ，但 $2 得不到的.

###### **8.7 javassist.expr.Instanceof**

`Instanceof 代表的是Instanceof 表达式。`

| $0       | null                                                         |
| -------- | ------------------------------------------------------------ |
| $1       | The value on the left hand side of the original instanceof operator. |
| $_       | The resulting value of the expression. The type of $_ is boolean. |
| $r       | The type on the right hand side of the instanceof operator.  |
| $type    | A java.lang.Class object representing the type on the right hand side of the instanceof operator. |
| $proceed | The name of a virtual method executing the original instanceof expression. It takes one parameter (the type is java.lang.Object) and returns true if the parameter value is an instance of the type on the right hand side of the original instanceof operator. Otherwise, it returns false. |

`$w, $args 和 $$  也是允许的`。



###### **8.8 javassist.expr.Cast**

`Cast 代表的是一个转型表达式。`

| $0       | null                                                         |
| -------- | ------------------------------------------------------------ |
| $1       | The value the type of which is explicitly cast.              |
| $_       | The resulting value of the expression. The type of $_ is the same as the type after the explicit casting, that is, the type surrounded by ( ). |
| $r       | the type after the explicit casting, or the type surrounded by ( ). |
| $type    | A java.lang.Class object representing the same type as $r.   |
| $proceed | The name of a virtual method executing the original type casting. It takes one parameter of the type java.lang.Object and returns it after the explicit type casting specified by the original expression. |

`$w, $args 和 $$  也是允许的。`



###### **8.9 javassist.expr.Handler**

`Handler 代表的是一个try catch 声明。`

| $1    | The exception object caught by the catch clause.             |
| ----- | ------------------------------------------------------------ |
| $r    | the type of the exception caught by the catch clause. It is used in a cast expression. |
| $w    | The wrapper type. It is used in a cast expression.           |
| $type | A java.lang.Class object representing the type of the exception caught by the catch clause. |

#### **九： 新增一个方法或者field**

###### Javassist 允许开发者创建一个新的方法或者构造方法。

`新增一个方法，例如：`

```java
CtClass point = ClassPool.getDefault().get("Point");

CtMethod m = CtNewMethod.make(
   "public int xmove(int dx) { x += dx; }",
 point);

point.addMethod(m);
```

`在方法中调用其他方法，例如：`

```java
CtClass point = ClassPool.getDefault().get("Point");

CtMethod m = CtNewMethod.make(

               "public int ymove(int dy) { $proceed(0, dy); }",

                point, "this", "move");

//其效果如下：

public int ymove(int dy) { this.move(0, dy); }
```

`下面是javassist提供另一种新增一个方法（未看明白）：`

`Javassist provides another way to add a new method. You can first create an abstract method and later give it a method body:`

```java
CtClass cc = ... ;

CtMethod m = new CtMethod(CtClass.intType, "move",

                       new CtClass[] { CtClass.intType }, cc);

cc.addMethod(m);

m.setBody("{ x += $1; }");

cc.setModifiers(cc.getModifiers() & ~Modifier.ABSTRACT);
```



###### **9.1 递归方法**

```java
CtClass cc = ... ;

CtMethod m = CtNewMethod.make("public abstract int m(int i);", cc);

CtMethod n = CtNewMethod.make("public abstract int n(int i);", cc);

cc.addMethod(m);

cc.addMethod(n);

m.setBody("{ return ($1 <= 0) ? 1 : (n($1 - 1) * $1); }");

n.setBody("{ return m($1); }");

cc.setModifiers(cc.getModifiers() & ~Modifier.ABSTRACT);
```

###### **9.2 新增field**

`如下：`

```java
CtClass point = ClassPool.getDefault().get("Point");

CtField f = new CtField(CtClass.intType, "z", point);

point.addField(f);

//point.addField(f, "0");    // initial value is 0.
```

`或者：`

```java
CtClass point = ClassPool.getDefault().get("Point");

CtField f = CtField.make("public int z = 0;", point);

point.addField(f);
```



###### **9.3 移除方法或者field**

```java
//调用removeField()或者removeMethod()。
```



##### **10 注解**

###### `获取注解信息：`

```java
//注解

public @interface Author {

​    String name();

​    int year();

}

//javassist代码

CtClass cc = ClassPool.getDefault().get("Point");

Object[] all = cc.getAnnotations();

Author a = (Author)all[0];

String name = a.name();

int year = a.year();

System.out.println("name: " + name + ", year: " + year);


```

##### **12 import**

```java
引用包：

ClassPool pool = ClassPool.getDefault();

pool.importPackage("java.awt");

CtClass cc = pool.makeClass("Test");

CtField f = CtField.make("public Point p;", cc);

cc.addField(f);
```



##### **13 限制**

1.  不支持java5.0的新增语法。不支持注解修改，但可以通过底层的javassist类来解决，具体参考：javassist.bytecode.annotation
2. 不支持数组的初始化，如String[]{"1","2"}，除非只有数组的容量为1
3. 不支持内部类和匿名类
4. 不支持continue和btreak 表达式。
5. 对于继承关系，有些不支持。例如

```java
class A {} 

class B extends A {} 

class C extends B {} 



class X { 

​    void foo(A a) { .. } 

​    void foo(B b) { .. } 

}

//如果调用  x.foo(new C())，可能会调用foo(A) 。
```



6.推荐开发者用#分隔一个class name和static method或者 static field。例如：

javassist.CtClass.intType.getName()推荐用javassist.CtClass#intType.getName()

##### **15 debug**

`可以设置一个文件夹，javassist生成的class会保存在该文件夹下面。例如：CtClass.debugDump = "./dump"; 默认debugDump=null. ` 