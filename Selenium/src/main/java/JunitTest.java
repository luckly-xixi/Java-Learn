import com.sun.org.apache.xpath.internal.Arg;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.swing.*;
import java.util.stream.Stream;

public class JunitTest {

    public static Stream<Arguments> Generator() {
        return Stream.of(Arguments.arguments(1,"张三"),
                Arguments.arguments(2,"李四"),
                Arguments.arguments(3,"王五"));
    }

    @Test // 不能和ParameterizeTest一起使用
    void test1() {
        System.out.println("Test标签可以不写在main方法中就可以执行");
    }

    @Disabled
    void test2() {
        System.out.println("Disabled 标签会被忽略，即使执行也会报错，无法执行");
    }

    @BeforeAll
    static void SetUp() {
        System.out.println("BeforAll 标签是在执行测试方法之前的前置方法，也就是说，测试执行前只先执行一次BeforAll");
        System.out.println("初始化在前，如JDBC连接数据库、创建驱动打开网页等");
    }

    @AfterAll
    static void TearDown() {
        System.out.println("BeforEach 标签是 在执行测试方法之后的后置方法，也就是说，所有的测试执行完之后后只执行一次AfterAll");
        System.out.println("关闭资源在后，如关闭数据库连接、关闭浏览器等");
    }


    @BeforeEach
    void BeforeEachTest() {
        System.out.println("BeforeEach 标签是在每一个测试方法执行前都会执行一次");
    }


    @AfterEach
    void AfterEachTest() {
        System.out.println("AfterEach 标签是在每一个测试方法执行之后都会执行一次");
    }

    //单参数ValueSource参数是数组
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test3(int i) {
        System.out.println(i);
    }

    //单参数 // ValueSource 注解 的参数是一组
    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void Test3(String number) {
        System.out.println(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Test4(int num) {
        System.out.println(num);
    }

    //单参数  CsvFileSource 注解通过一个文件获取参数
    // 文件中的内容通过逗号隔开为一列 ，打印时有一行就会打印一次
    @ParameterizedTest
    @CsvFileSource(resources = "test1.csv")
    void Test5(String name) {
        System.out.println(name);
    }


    //多参数，参数可以是不同类型
    @ParameterizedTest
    @MethodSource("Generator")
    void Test7(int num,String name) {
        System.out.println(num + ":" + name);
    }

}
