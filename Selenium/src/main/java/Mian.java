import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static java.lang.Thread.sleep;

public class Mian {

    public static void main(String[] args) throws InterruptedException {
//        test1();
        test2();


    }

    private static void test2() {
        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
//        WebElement element = webDriver.findElement(By.cssSelector(".s_ipt"));
        //找到输入框并输入内容
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("java");
        //点击
//        webDriver.findElement(By.cssSelector("#su")).click();
        //submit如果放在from标签下，效果和click一样，但是放在非form标签下则会报错
        webDriver.findElement(By.cssSelector("#su")).submit();
        //清空内容
        webDriver.findElement(By.cssSelector("#kw")).clear();
        String button_value = webDriver.findElement(By.cssSelector("#su")).getAttribute("value");
//        System.out.println(button_value);
        if(button_value.equals("百度一下")) {
            System.out.println("测试通过");
        } else  {
            System.out.println(button_value);
            System.out.println("测试不通过");
        }
    }



    private static void test1() throws InterruptedException {
        int flg = 0;
        ChromeOptions options = new ChromeOptions();
        //允许所有的请求
        options.addArguments("--remote-all-origins=*");
        WebDriver webDriver = new ChromeDriver(options);
        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //通过css类选择器定位元素
        //css选择器语法：
//        id选择器: #id
//        类选择器: .class
//        标签选择器: 标签名
//        后代选择器: 父级选择器 子级选择器
        WebElement element = webDriver.findElement(By.cssSelector(".s_ipt"));
        //xpath语法：
//        绝对路径：/html/head/title（不常用）
//        相对路径：//
//            相对路径+索引:  //form/span[1]/input
//            相对路径+属性值:  //input[@class="s_ipt"]
//            相对路径+通配符:  //*[@*="su"]
//            相对路径+文本匹配:  a[text()="新闻"]
        //通过返回的对象进行操作
        element.sendKeys("软件测试");
        //找到点击按钮，并点击
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(3000);
        //校验，并找到结果集
        List<WebElement> elements = webDriver.findElements(By.cssSelector("a em"));
        for(int i=0; i<elements.size(); i++) {
            if(elements.get(i).getText().equals("软件测试")) {
                flg = 1;
            }
        }
        if(flg == 1) {
            System.out.println("测试通过");
        } else  {
            System.out.println("测试不通过");
        }
    }


}
