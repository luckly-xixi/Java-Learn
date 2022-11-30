package book;

public class BookList {

    private static final int DEFAULT_SIZE = 10;

    private Book[] books = new Book[DEFAULT_SIZE];

    public Book getBooks(int pos) {
        return this.books[pos];
    }

    private int usedSize;//记录当前books数组当中有多少本书？

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public BookList() {
        books[0] = new Book("西游记","吴承恩",68,"小说");
        books[1] = new Book("红楼梦","曹雪芹",48,"小说");
        books[2] = new Book("水浒传","施耐庵",72,"小说");
        books[3] = new Book("三国演义","罗贯中",98,"小说");
        this.usedSize = 4;
    }
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
