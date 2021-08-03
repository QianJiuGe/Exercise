package org.example.StudyProxy;

/**
 * 要求在该实现类每次问候某人时，必须把问候的细节记录到日志文件里。
 * 并且不允许修改原来的Helloimplements类。
 * 在现实场景中，Helloimplements可能是第三方的jar包提供的，我们没有办法修改代码。
 *
 * 使用动态代理就可以优雅的实现这个要求
 */

public class Helloimplements implements IHello{
    @Override
    public void sayHello(String name) {
        //System.out.println("问候之前的日志记录...");
        System.out.println("Hello " + name);
    }

    @Override
    public void sayGoogBye(String name) {
        System.out.println(name+" GoodBye!");
    }
}
