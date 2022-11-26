package operate;

import book.Book;
import book.BookList;

public class ShowOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("打印图书目录");
        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book book = bookList.getBooks(i);
            System.out.println(book);
        }
    }
}
