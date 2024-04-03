package baitap;

import baitap.entity.BookBai9;
import generics.GenericObjectInputStream;
import generics.GenericObjectOutputStream;

import java.util.ArrayList;
import java.util.List;

public class BookManagerBai9
{
    private static final List<BookBai9> listBook = new ArrayList<>();

    public static void addBook(BookBai9 bookBai9)
    {
        listBook.add(bookBai9);
    }

    public static void updateBook(BookBai9 bookBai9)
    {
        BookBai9 bookToUpdate = listBook.stream().filter(b -> b == bookBai9).findAny().orElse(null);
        if (bookToUpdate == null)
        {
            System.out.println("Không tìm thấy sách");
            return;
        }
        System.out.println("Nhập thông tin mới");
        bookToUpdate.inputData();
        System.out.println("Cập nhật thành công");
    }

    public static void deleteBook(String title)
    {
        BookBai9 bookToDelete = listBook.stream().filter(b -> b.getTitle().equals(title)).findAny().orElse(null);
        if (bookToDelete == null)
        {
            System.out.println("Không tìm thấy sách");
            return;
        }
        System.out.println(listBook.remove(bookToDelete));
        System.out.println("Xóa thành công");
    }

    public static void displayAllBooks()
    {
        System.out.println("Nhập tên file cần xem");
        String filePath = Bai1.scanner.nextLine();
        List<BookBai9> listBook = GenericObjectInputStream.readObjectStream(filePath);
        System.out.println(listBook);
    }

    public static void importToFile()
    {
        System.out.println("Nhập đường dẫn file để lưu thông tin các cuốn sách");
        String filePath = Bai1.scanner.nextLine();
        GenericObjectOutputStream.writeObjectStream(filePath, listBook);
        System.out.println("Lưu thành công");
    }
}
