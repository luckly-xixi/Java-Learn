import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Mian {

    public static void main(String[] args) throws InterruptedException, IOException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
    }



    private static void test8() throws IOException {
        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
        //截图，将输出文件转换为File类型,记得强转
        File file = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        //将截图保存
        FileUtils.copyFile(file,new File("D://image//2023_09_23.png"));
    }




    private static void test7() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
        //打开新闻页面
        webDriver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        sleep(1000);
        //getWindowHandle是获取get打开的页面的句柄
        //getWindowHandles获取当前页面所有元素的句柄（适用于另开页面进行的页面资源切换）
        Set<String> handles = webDriver.getWindowHandles();
        String target_handle = "";
        for (String handle:handles) {
            target_handle = handle;
        }
        webDriver.switchTo().window(target_handle);

        webDriver.findElement(By.cssSelector("#ww")).sendKeys("新闻联播");
        webDriver.findElement(By.cssSelector("#s_btn_wr")).click();
        //close和quit的区别
        // close关闭跳转过来的原始页面，quit直接关闭浏览器
        // close不会清空浏览器的缓存，quit会清空浏览器的缓存
//        webDriver.close();
//        webDriver.quit();
    }


    private static void test6() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("521");
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(3000);
        //找到图片元素
//        WebElement webElement = webDriver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/a[6]"));
        WebElement webElement = webDriver.findElement(By.cssSelector("#s_tab > div > a.s-tab-item.s-tab-item_1CwH-.s-tab-pic_p4Uej.s-tab-pic"));
        //鼠标右击

        Actions actions = new Actions(webDriver);
        sleep(1000);
        actions.moveToElement(webElement).contextClick().perform();
    }


    private static void test5() throws InterruptedException {
        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("521");
        webDriver.findElement(By.cssSelector("#su")).click();
        sleep(500);
        //control+a
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"A");
        sleep(500);
        //control+x
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"X");
        sleep(500);
        //control+v
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"V");
        sleep(500);
    }



    private static void test4() throws InterruptedException {

    WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
    webDriver.get("https://www.baidu.com");
    webDriver.findElement(By.cssSelector("#kw")).sendKeys("521");
    webDriver.findElement(By.cssSelector("#su")).click();
        sleep(300);
        //浏览器后退
    webDriver.navigate().back();
        sleep(300);
        //浏览器刷新
    webDriver.navigate().refresh();
        sleep(300);
        //浏览器前进
    webDriver.navigate().forward();
        sleep(300);
        //操作滚动条
    ((JavascriptExecutor)webDriver).executeScript("document.documentElement.scrollTop=10000");
    //最大化
    webDriver.manage().window().maximize();
        sleep(300);
    //全屏
    webDriver.manage().window().fullscreen();
        sleep(300);
    //设置大小
    webDriver.manage().window().setSize(new Dimension(600,1000));
    }

    //隐式等待和显示等待的区别
    private static void test3() throws InterruptedException {

        WebDriver webDriver = new ChromeDriver(new ChromeOptions().addArguments("--remote-all-origins=*"));
        webDriver.get("https://www.baidu.com");
        sleep(3000);//隐式等待，等待的的是页面上的所有元素
        //判断元素是否可以被点击
        WebDriverWait wait = new WebDriverWait(webDriver,3000);
        //显示等待，等待的是一个条件（程序员自己设定）
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#bottom_layer > div > p:nth-child(8) > span")));

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
