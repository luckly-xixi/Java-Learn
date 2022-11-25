package user;

import book.BookList;
import operate.IOperation;

public abstract class User {

    protected String name;
    IOperation[] iOperations;

    public User(String name) {
        this.name = name;
    }
    public abstract int menu() ;

    public void doWork(int chioce, BookList bookList) {
        iOperations[chioce].work(bookList);
    }
}
