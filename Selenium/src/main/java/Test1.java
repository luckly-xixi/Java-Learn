import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)  // 设置测试方法的执行顺序s
//@TestMethodOrder(MethodOrderer.Random)  // 随机顺序执行
public class Test1 {
    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(
                "1,zhangsan",
                "2,lisi"
        ));
    }

    @ParameterizedTest
    @MethodSource("Generator")
    void Test01(String num, String name) {
        System.out.println("学号" + num + "姓名" + name);
    }

//    @Order(1)
    @Test
    void TestA() {
        System.out.println("A");
    }

//    @Order(2)
    @Test
    void TestC() {
        System.out.println("C");
    }

//    @Order(4)
    @Test
    void Test02() {
        System.out.println("2");
    }

//    @Order(3)
    @Test
    void Test03() {
        System.out.println("3");
    }
}
