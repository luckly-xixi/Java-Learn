package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class AddIOperation implements IOperation {

//    public void work(BookList bookList) {
//        System.out.println("新增图书");
//    }

    @Override
    public void work(BookList bookList) {
        System.out.println("新增图书");
        //录入书籍的信息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();

        System.out.println("请输入作者");
        String author = scanner.nextLine();

        System.out.println("请输入类型");
        String type = scanner.nextLine();

        System.out.println("请输入价格");
        int price = scanner.nextInt();

        //实例化新增书籍并把书籍信息填入
        Book book = new Book(name,author,price,type);

        //遍历书架查看书架当中是否有了新增书籍
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBooks(i);
            if(tmp.getName().equals(name)) {
                System.out.println("该书已存在");
                return;
            }
        }

        //通过上方操作，说明书架当中没有新增书籍，接下来开始将新增书籍放入书架
        bookList.setBook(book);
        //修改usedSize
        bookList.setUsedSize(currentSize+1);

        System.out.println("存放成功！");

    }
}
