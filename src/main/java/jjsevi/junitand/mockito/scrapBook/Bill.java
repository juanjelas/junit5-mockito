package jjsevi.junitand.mockito.scrapBook;

public class Bill {

    private Book book;

    public Bill(Book book) {
        this.book = book;
    }

    public int pay() {
        try {
            book.voidMethod();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return 1;
    }
}
