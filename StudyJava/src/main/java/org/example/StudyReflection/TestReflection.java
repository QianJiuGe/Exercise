package org.example.StudyReflection;

import org.junit.jupiter.api.Test;
import sun.plugin2.message.SetAppletSizeMessage;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * >反射被视为动态语言的关键，反射机制允许程序在执行期间借助Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法
 *
 * >记载完类之后，在堆内存的方法区中就产生了一个class类型的对象（一个类只有一个class对象），这个对象就包含了类的完整结构信息。
 * >我们可以通过这个对象看到类的结构、这个对象就像一面镜子，透过这个镜子看到类的机构，所以我们形象的称之为反射
 *
 * Java反射机制提供的功能：
 *  1. 在运行时判断任意一个对象所属的类
 *  2. 在运行时构造任意一个类的对象
 *  3. 在运行时判断一个类所具有的成员变量和方法
 *  4. 在运行时获取泛型信息
 *  5. 在运行时调用任意一个方法的成员变量和方法
 *  6. 在运行时处理注解
 *  7. 生成动态代理
 *
 * 反射相关的API：
 *  java.lang.CLass:代表一个类  (关键字是小写的 class)
 *  java.lang.reflect.Method:代表类的方法
 *  java.lang.reflect.Field:代表类的成员变量
 *  java.lang.reflect.Constructor:代表类的构造器
 *  ......
 *
 * >疑问1：什么时候需要用到反射？
 *      反射的特征：动态性
 *          如果在一开始的代码编写中不确定要用哪个类的对象，这个时候就应该使用反射。
 *          在运行的时候，根据需要来造对应的所需的类的对象！
 * >疑问2：如何看待反射和封装两个技术？是否矛盾了？
 *      不矛盾。封装性可以理解为建议，是正常需要。反射是理论上的可行性
 */
public class TestReflection {

    //反射之前，对于Person类的操作
    @Test
    public void test01(){
        //创建Person对象
        Person p1 = new Person("王芳金",14);
        //通过对象调用其内部属性
        p1.age = 18;
        System.out.println(p1);

        p1.meet();

        //在Person类外部，不可以通过Person类的对象调用其内部私有结构
        //比如：name，love()
    }

    //有了反射之后
    @Test
    public void test02() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Person.class;
        //1.通过反射可以创建person对象
        Constructor constructor = clazz.getConstructor(String.class, Integer.class);

        Object instance = constructor.newInstance("王芳金", 12);
        Person p1 = (Person)instance;
        System.out.println(instance);
        System.out.println(p1);
        //2.通过反射，调用对象制定的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p1, 26);
        System.out.println(p1);

        Method meet = clazz.getDeclaredMethod("meet");
        meet.invoke(p1);

        //通过反射是可以调用Person类的私有结构的。比如私有的构造器、方法、属性
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object o = cons1.newInstance("张富成");
        Person p2 = (Person)o;
        System.out.println(p2);

        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p2,"憨头");
        System.out.println(p2);

        //调用私有方法
        Method method = clazz.getDeclaredMethod("love");
        method.setAccessible(true);
        method.invoke(p2 );
    }

    /**
     * 1.类加载过程：
     *     经过javac.exe命令后，会生成一个或多个字节码文件(.class结尾)，接着我们使用java.exe命令对某个字节码文件进行解释运行。
     *     相当于将某个字节码文件加载到内存中。此过程就称为类的加载。记载到内存中的类就叫做运行时类，此运行时类就作为Class的一个实例。
     * 2.换句话说，**Class的实例就对应着一个运行时类**
     * 3.加载到内存中的运行时类会缓存一定时间，在此时间之类，我们可以通过不同的方式来获取此运行时类
     */

    /**
     * 获取Class实例的方式  (前三种方式需要掌握！！)
     */
    @Test
    public void test03() throws ClassNotFoundException {
        //方式一：调用运行时类的属性 .class
        Class clazz = Person.class;
        System.out.println(clazz);
        //方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三：（使用频率最高）调用Class的静态方法：forName(String classPath)
        //运行的时候才会报找不到该类的错  方式一编译时就会报错
        Class clazz3 = Class.forName("org.example.StudyReflection.Person");
        System.out.println(clazz3);

        System.out.println(clazz == clazz2);
        System.out.println(clazz == clazz3);

        //方式四：使用类的加载器(了解既可)
        ClassLoader classLoader = TestReflection.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("org.example.StudyReflection.Person");
        System.out.println(clazz4);
        System.out.println(clazz4 == clazz);
    }

    /**
     * Java中万物都是对象
     */
}




