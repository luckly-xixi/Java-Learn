import java.util.Random;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Random random = new Random();
        int ranNum = random.nextInt(100);//[0,100)
//        int ranNum = random.nextInt(100)+100;//[100,200)//生成100到200之间的随机数字
//        int ranNum = random.nextInt(50)+50;//[50,100)//生成50到100之间的随机数字
        //生成0-100的随机数字，不包含100

        while (true) {
            System.out.println("请输入猜的数字");
            int num = input.nextInt();
            if (num > ranNum) {
                System.out.println("猜大了");
            } else if (num < ranNum) {
                System.out.println("猜小了");
            } else {
                System.out.println("猜对了");
                break;
            }
        }
    }
}
