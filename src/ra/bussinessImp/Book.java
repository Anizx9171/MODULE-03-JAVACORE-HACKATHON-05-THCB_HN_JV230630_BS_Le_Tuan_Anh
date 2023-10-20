package ra.bussinessImp;

import ra.bussiness.IBook;
import ra.config.Config;

public class Book implements IBook {
    private static int count = 1;
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book() {
        this.bookId = Book.count++;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }


    @Override
    public void inputData() {
        System.out.println("Nhập tên sách");
        this.bookName = Config.scanner().nextLine();
        System.out.println("Nhập tiêu đề");
        this.title = Config.scanner().nextLine();
        System.out.println("Nhập số trang");
        this.numberOfPages = Integer.parseInt(Config.scanner().nextLine());
        System.out.println("Giá nhập");
        this.importPrice = Float.parseFloat(Config.scanner().nextLine());
        System.out.println("Giá bán");
        this.exportPrice = Float.parseFloat(Config.scanner().nextLine());
        System.out.println("""
                Trạng thái
                1.true
                2.false
                """);
        this.bookStatus = Integer.parseInt(Config.scanner().nextLine()) == 1;
        this.interest = this.exportPrice - this.importPrice;
    }
    @Override
    public void displayData() {
        System.out.println("Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", importPrice=" + Config.formatter.format(importPrice) + "đ" +
                ", exportPrice=" + Config.formatter.format(exportPrice) + "đ" +
                ", interest=" + Config.formatter.format(interest) + "đ" +
                ", bookStatus=" + bookStatus +
                '}');
    }
}
