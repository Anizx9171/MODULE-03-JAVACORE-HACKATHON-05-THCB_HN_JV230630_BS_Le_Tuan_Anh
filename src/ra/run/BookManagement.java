package ra.run;

import ra.bussinessImp.Book;
import ra.config.Config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement {
    static List<Book> books = new ArrayList<>();
    public static void main(String[] args) {
        int choice;
        while (true){
            System.out.println("""
                    ****************JAVA-HACKATHON-05-BASIC-MENU***************
                    1. Nhập số sách và nhập thông tin sách
                    2. Hiển thị thông tin các sách
                    3. Sắp xếp sách theo lợi nhuận giảm dần
                    4. Xóa sách theo mã sách
                    5. Tìm kiếm sách theo tên sách
                    6. Thay đổi trạng thái của sách theo mã sách
                    7. Thoát""");
            choice = Integer.parseInt(Config.scanner().nextLine());
            switch (choice){
                case 1:
                    handleAdd();
                    break;
                case 2:
                    handleShow();
                    break;
                case 3:
                    handleSort();
                    break;
                case 4:
                    handleDelete();
                    break;
                case 5:
                    handleSearch();
                    break;
                case 6:
                    handleChangeBStatus();
                    break;
                case 7:
                    System.exit(0);
                default:
                    break;
            }
        }
    }

    private static void handleChangeBStatus() {
        books.forEach(book ->{
            System.out.printf("id: %d, name: %s, status: %s\n",book.getBookId(),book.getBookName(),book.getBookStatus());
        });
        System.out.println("Nhập mã sách muốn thay đổi status");
        int bookId = Integer.parseInt(Config.scanner().nextLine());
        books.forEach(book ->{
            if (book.getBookId() == bookId) {
                book.setBookStatus(!book.getBookStatus());
                System.out.println("Thay đổi trạng thái thành công");
                return;
            }
        });
        System.out.println("Không tìm thấy sách có id "+ bookId);
    }

    private static void handleSearch() {
        System.out.println("Nhập tên sách muốn tìm");
        String bookName = Config.scanner().nextLine();
        boolean check = false;
        System.out.println("Kết quả tìm kiếm:");
        for(Book book : books){
            if (book.getBookName().toLowerCase().contains(bookName.toLowerCase())){
                book.displayData();
                System.out.println();
                check = true;
            }
        }
        if (!check){
            System.out.println("Không tìm thấy sách có tên trùng khớp");
        }
    }

    private static void handleDelete() {
        books.forEach(book ->{
            System.out.printf("id: %d, name: %s\n",book.getBookId(),book.getBookName());
        });
        System.out.println("Chọn sách muốn xóa");
        int idDelete = Integer.parseInt(Config.scanner().nextLine());
        for (Book book: books){
            if (book.getBookId() == idDelete){
                books.remove(book);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sách có id " + idDelete);
    }

    private static void handleSort() {
        Collections.sort(books);
        System.out.println("Xắp xếp thành công");
    }

    private static void handleShow() {
        books.forEach(book -> book.displayData());
    }

    private static void handleAdd() {
        System.out.println("Nhập số sách muốn thêm:");
        int count = Integer.parseInt(Config.scanner().nextLine());
        for (int i = 0; i < count; i++){
            System.out.println("Thêm sách mới " + (i + 1));
            Book book = new Book();
            book.inputData();
            books.add(book);
        }
    }
}
