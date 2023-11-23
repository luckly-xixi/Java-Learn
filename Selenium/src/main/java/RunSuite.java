import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
//@SelectPackages(value = {"package01", "package02"})  // 按包来跑
@SelectClasses({ JunitTest.class, Test1.class})  // 按类来跑
// 顺序就是（包/类）的参数顺序
public class RunSuite {

}
