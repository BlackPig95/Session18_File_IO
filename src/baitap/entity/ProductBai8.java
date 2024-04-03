package baitap.entity;

import baitap.Bai1;

import java.io.Serializable;

public class ProductBai8 implements Serializable
{
    private String id;
    private String name;
    private String brand;
    private double price;
    private String description;

    public ProductBai8()
    {
    }

    public ProductBai8(String id, String name, String brand, double price, String description)
    {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void inputData()
    {
        System.out.println("Nhập mã sản phẩm");
        this.id = Bai1.scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        this.name = Bai1.scanner.nextLine();
        System.out.println("Nhập hãng sản xuất");
        this.brand = Bai1.scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        this.price = Double.parseDouble(Bai1.scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm");
        this.description = Bai1.scanner.nextLine();
    }

    @Override
    public String toString()
    {
        return "ProductBai8{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
