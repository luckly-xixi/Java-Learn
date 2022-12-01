package operate;

import book.Book;
import book.BookList;

import java.util.Scanner;

public class DelOperation implements IOperation {

    @Override
    public void work(BookList bookList) {
        System.out.println("删除图书");
        System.out.println("请输入你要删除的图书的名字");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        //遍历数组，查找书架当中是否有你要删除的图书
        int currentSize = bookList.getUsedSize();
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBooks(i);
            //删除图书的实现通过后一本书对前一本书的覆盖
            if(tmp.getName().equals(name)) {
                   index = i;
                   break;
                }
            }
        //挪动数据
        for (int j = index; j < currentSize-1; j++) {
            Book book = bookList.getBooks(j+1);
            bookList.setBook(j,book);
        }
        //修改size
        bookList.setUsedSize(currentSize-1);
        //删除并且向前覆盖之后，最后一本书的引用置为null
        bookList.setBook(currentSize-1,null);

        System.out.println("删除成功");
    }
}
