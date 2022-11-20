package Dome2;

import Demo1.TestDemo1;

public class TestDemo3 extends TestDemo1 {

    public void func () {
        System.out.println(super.a);
        System.out.println(super.name);
    }

    public static void main(String[] args) {
        TestDemo1 testDemo1 = new TestDemo1();
//        System.out.println(testDemo1.a);
//        System.out.println(testDemo1.name);
            TestDemo3 testDemo3 = new TestDemo3();
            testDemo3.func();
    }
}
