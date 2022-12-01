package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        System.out.println("输入你要借阅的图书");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        //遍历书架查看该书是否被借出
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBooks(i);
            if(book.getName().equals(name) && book.isBorrowed() == false) {
                book.setBorrowed(true);
                System.out.println("借阅成功");
                return;
            }
        }
        System.out.println("该书已被借出");
    }
}
