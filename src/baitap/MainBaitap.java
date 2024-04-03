package baitap;

import IOFile.Student;
import baitap.entity.BookBai9;
import baitap.entity.StudentBai7;

import java.awt.print.Book;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainBaitap
{
    public static void main(String[] args)
    {
        //Bai1
        String[] bai1 = Bai1.readBai1().split(" ");
        System.out.println(Bai1.readBai1());
        System.out.println("Số lượng từ: " + bai1.length);
        //Bai2
        try
        {
            Bai2.readAndCopyByte();
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        //Bai3
        //Nếu dùng dấu cách thường thì sẽ không loại bỏ được new line character
        String[] bai3 = Bai3.readLongestWords().split("\\s+");
        List<String> longestWords = new ArrayList<>();
        int longest = 0;
        for (String word : bai3)
        {
            if (word.length() == longest)
            {
                longestWords.add(word);
            } else if (word.length() > longest)
            {
                longest = word.length();
                longestWords.clear();
                longestWords.add(word);
            }
        }
        System.out.println("Các từ có độ dài lớn nhất: ");
        System.out.println(longestWords);
        //Bai4
        Bai4.reverseFile();
        //Bai5
        Bai5.readCSV().forEach(country -> System.out.println(country));
        //Bai 6
        Bai6.countFrequency();
//        //Bai 7
        StudentBai7 student1 = new StudentBai7(1, "Học sinh A");
        StudentBai7 student2 = new StudentBai7(2, "Học sinh B");
        List<StudentBai7> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        //Ghi vào file
        Bai7.writeStudentBai7("src/baitap/files/bai7.txt", list);
        //Đọc thông tin từ file
        List<StudentBai7> listFromFile = Bai7.readStudentBai7("src/baitap/files/bai7.txt");
        System.out.println(listFromFile);

        //Bai 8
        //Ghi thông tin vào file
        Bai8.importToFile();
        //Đọc danh sách sản phẩm từ file
        Bai8.displayInfoFromFile();
        //Tìm 1 sản phẩm và hiển thị thông tin
        System.out.println(Bai8.searchFromFile());
        //Bai 9
        //Tạo ra vài cuốn sách để test chức năng thêm vào list
        BookBai9 book1 = new BookBai9("Sach1", "Tác giả 1", "Xuất bản1", 10);
        BookBai9 book2 = new BookBai9("Sach2", "Tác giả 2", "Xuất bản2", 10);
        BookBai9 book3 = new BookBai9("Sach3", "Tác giả 3", "Xuất bản3", 10);
        BookBai9 book4 = new BookBai9("Sach4", "Tác giả 4", "Xuất bản4", 10);
        BookManagerBai9.addBook(book1);
        BookManagerBai9.addBook(book2);
        BookManagerBai9.addBook(book3);
        BookManagerBai9.addBook(book4);
        //Ghi danh sách vừa thêm vào file
        BookManagerBai9.importToFile();
        //Đọc ra danh sách từ file
        BookManagerBai9.displayAllBooks();
        //Cập nhật thông tin, test nhanh nên không làm chức năng tìm kiếm từ danh sách
        BookManagerBai9.updateBook(book3);
        //Xóa sách, test nhanh nên không làm chức năng tìm kiếm từ danh sách
        BookManagerBai9.deleteBook("Sach2");
        //Sau khi upadte và xóa, ghi lại thông tin 1 lần nữa để cập nhật
        BookManagerBai9.importToFile();
        //Hiển thị lại thông tin để kiểm tra
        BookManagerBai9.displayAllBooks();
    }
}
