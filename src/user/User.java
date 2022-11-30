package user;

import book.BookList;
import operate.IOperation;

public abstract class User {

    protected String name;
    IOperation[] iOperations;//通过接口数组进行对各种操作功能的编排

    public User(String name) {
        this.name = name;
    }
    public abstract int menu() ;

    public void doWork(int chioce, BookList bookList) {

        this.iOperations[chioce].work(bookList);
    }
}
