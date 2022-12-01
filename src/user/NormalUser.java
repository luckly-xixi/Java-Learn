package user;

import operate.*;

import java.util.Scanner;

public class NormalUser extends User{


    public NormalUser(String name) {

        super(name);

        super.iOperations = new IOperation[]{
                //在实例化接口数组的时候将初始化的操作功能进行编排
                new ExitOperation(),
                new BorrowOperation(),
                new FindIOperation(),
                new ReturnOperation(),
        };
    }

    public int menu() {
        System.out.println("*********************");
        System.out.println("Hello "+name+" 欢迎来到图书小练习");
        System.out.println("1.借阅图书");
        System.out.println("2.查找图书");
        System.out.println("3.归还图书");
        System.out.println("0.退出系统");
        System.out.println("*********************");
        System.out.println("请输入你的操作:");

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

}
