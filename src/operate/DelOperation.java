package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
//        System.out.println("删除图书信息");

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBooks(i);

            //删除图书的实现通过后本书对该书的覆盖
            if(tmp.getName().equals(name)) {
                for (int j = i; j < currentSize-1; j++) {
                  Book book = bookList.getBooks(j);
                  bookList.setBook(j,book);
                }
            }
        }
        bookList.setUsedSize(currentSize-1);
        bookList.setBook(currentSize-1,null);
    }
}
