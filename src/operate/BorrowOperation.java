package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{

    @Override
    public void work(BookList bookList) {
        System.out.println("借阅图书");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int currentSize = bookList.getUsedSize();

        for (int i = 0; i < currentSize; i++) {

            Book book = bookList.getBooks(i);

            if(book.getName().equals(name)) {

                System.out.println("找到该书：");
                System.out.println(book);
                return;
            }
        }
        System.out.println("没有该书籍");
    }
}
