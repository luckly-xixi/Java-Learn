package operate;

import book.BookList;

public class DelOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书信息");
    }
}
