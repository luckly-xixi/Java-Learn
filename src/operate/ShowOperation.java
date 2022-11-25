package operate;

import book.BookList;

public class ShowOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("打印图书目录");
    }
}
