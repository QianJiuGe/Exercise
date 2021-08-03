package org.example.StudyProxy;

public class Test {
    static public void main(String[] arg) {
        DynaProxyHello helloproxy = new DynaProxyHello();
        Helloimplements hello = new Helloimplements();
        IHello ihello = (IHello) helloproxy.bind(hello);
        ihello.sayHello("Jerry");
    }
}
