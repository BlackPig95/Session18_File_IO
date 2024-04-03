package baitap.entity;

import baitap.Bai1;

import java.io.Serializable;

public class BookBai9 implements Serializable
{
    private String title;
    private String author;
    private String publisher;
    private float price;

    public BookBai9()
    {
    }

    public BookBai9(String title, String author, String publisher, float price)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public void inputData()
    {
        System.out.println("Nhập tiêu đề sách");
        this.title = Bai1.scanner.nextLine();
        System.out.println("Nhập tác giả cuốn sách");
        this.author = Bai1.scanner.nextLine();
        System.out.println("Nhập nhà xuất bản sách");
        this.publisher = Bai1.scanner.nextLine();
        System.out.println("Nhập giá bán sách");
        this.price = Float.parseFloat(Bai1.scanner.nextLine());
    }

    @Override
    public String toString()
    {
        return "BookBai9{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }
}
