package user;

import operate.*;

import java.util.Scanner;

public class AdminUser extends User{

    public AdminUser(String name) {
        super(name);
        this.iOperations = new IOperation[] {
                new ExitOperation(),
                new AddIOperation(),
                new DelOperation(),
                new FindIOperation(),
                new ShowOperation(),
        };

    }

    @Override
    public int menu() {
        System.out.println("*********************");
        System.out.println("Hello "+name+" 欢迎来到图书小练习");
        System.out.println("1.新增图书");
        System.out.println("2.删除图书");
        System.out.println("3.查找图书");
        System.out.println("4.打印图书");
        System.out.println("0.退出系统");
        System.out.println("*********************");
        System.out.println("请输入你的操作:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

}
