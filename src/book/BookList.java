package book;

public class BookList {

    private static final int DEFAULT_SIZE = 10;
    private Book[] books = new Book[DEFAULT_SIZE];
    private int usedSize;//记录当前books数组当中有多少本书？

    public void setBook(int pos,Book book) {
        books[pos] = book;
    }
    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
