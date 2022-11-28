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

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入书名");
        String name = scanner.nextLine();

        System.out.println("请输入作者");
        String author = scanner.nextLine();

        System.out.println("请输入类型");
        String type = scanner.nextLine();

        System.out.println("请输入价格");
        int price = scanner.nextInt();

        Book book = new Book(name,author,price,type);

        int currentSize = bookList.getUsedSize();
        for (int i = 0; i < currentSize; i++) {
            Book tmp = bookList.getBooks(i);
            if(tmp.getName().equals(name)) {
                System.out.println("该书已存在");
                return;
            }
        }

        bookList.setBook(currentSize,book);
        //修改usedSize
        bookList.setUsedSize(currentSize+1);
    }
}
